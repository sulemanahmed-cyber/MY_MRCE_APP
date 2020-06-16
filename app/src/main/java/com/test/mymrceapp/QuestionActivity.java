package com.test.mymrceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static com.test.mymrceapp.Sets_Activity.category_id;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener{
private TextView question,qcount,timer;
private Button option1,option2,option3,option4;
private List<Question>questionList;
 private int question_number;
private CountDownTimer countdown;
private int score;
private FirebaseFirestore firestore;
private int setNo;
private Dialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        setNo = getIntent().getIntExtra("SETNO",1);
        question = findViewById(R.id.question);
        qcount = findViewById(R.id.question_number);
        loadingDialog = new Dialog(QuestionActivity.this);
        loadingDialog . setContentView(R.layout.loading_progressbar);
        loadingDialog.setCancelable(false);
        loadingDialog.getWindow().setBackgroundDrawableResource(R.drawable.progress_background);
        loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        loadingDialog.show();
        timer = findViewById(R.id.timer);
firestore = FirebaseFirestore.getInstance();
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);
        getQuestionsList();
        score = 0;
    }

    private void getQuestionsList() {
        questionList = new ArrayList<>();
        firestore.collection("Online_Test").document("CAT" + String.valueOf(category_id))
                .collection("SET" +String.valueOf(setNo)).get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            QuerySnapshot questions = task.getResult();
                            for(QueryDocumentSnapshot doc : questions){
                                questionList.add(new Question(doc.getString("QUESTION"),
                                        doc.getString("A"),
                                        doc.getString("B"),
                                        doc.getString("C"),
                                        doc.getString("D"),
                                        Integer.valueOf(doc.getString("ANSWER"))));
                            }
                            setQuestion();

                        }else {
                            Toast.makeText(QuestionActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                        loadingDialog.cancel();
                    }
                });
       /* questionList.add(new Question("Question 1","A","B","C","D",2));
        questionList.add(new Question("Question 2","B","B","D","C",2));
        questionList.add(new Question("Question 3","C","B","C","D",2));
        questionList.add(new Question("Question 4","A","B","C","D",2));
        questionList.add(new Question("Question 5","A","B","C","D",2));*/
    }

    private void setQuestion() {
        timer.setText(String.valueOf(10));
        question.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getOptionA());
        option2.setText(questionList.get(0).getOptionB());
        option3.setText(questionList.get(0).getOptionC());
        option4.setText(questionList.get(0).getOptionD());

        qcount.setText(String.valueOf(1)+ "/" + String.valueOf(questionList.size()));
        startTimer();
        question_number = 0 ;
    }

    private void startTimer() {
         countdown = new CountDownTimer(12000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(millisUntilFinished / 1000));

            }

            @Override
            public void onFinish() {
                changeQuestion();

            }
        };
        countdown.start();
    }

    @Override
    public void onClick(View v) {
        int selectedOption = 0;
        switch (v.getId()){
            case R.id.option1 :
                selectedOption = 1;
                break;
            case R.id.option2 :
                selectedOption = 2;
                break;
            case R.id.option3 :
                selectedOption = 3;
                break;
            case R.id.option4 :
                selectedOption = 4;
                break;

            default:


        }
        countdown.cancel();
        checkAnswer(selectedOption,v);

    }

    private void checkAnswer(int selectedoption,View view) {
        if(selectedoption == questionList.get(question_number).getCorrectAns())
        {
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
            score++;
            //right
        }else{
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            //wrong
            switch (questionList.get(question_number).getCorrectAns())
            {
                case 1:
                    option1.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 2:
                    option2.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 3:
                    option3.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
                case 4:
                    option4.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    break;
            }
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                changeQuestion();
            }
        },2000);

    }
    private void changeQuestion()
    {
        if (question_number<questionList.size() - 1)
        {
            question_number++;
            playAnim(question,0,0);
            playAnim(option1,0,1);
            playAnim(option2,0,2);
            playAnim(option3,0,3);
            playAnim(option4,0,4);

            qcount.setText(String.valueOf(question_number + 1) + "/" + String.valueOf(questionList.size()));
            timer.setText(String.valueOf(10));
            startTimer();



        }else {
            //goto scorecard
           Intent intent = new Intent(QuestionActivity.this,Score.class);
           intent.putExtra("SCORE",String.valueOf(score) + "/" + String.valueOf(questionList.size()));
           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
           startActivity(intent);

           // QuestionActivity.this.finish();
        }
    }

    private void playAnim(final View view, final int value, final int viewnum) {
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100).setInterpolator(new DecelerateInterpolator())
        .setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (value == 0)
                {
                    switch(viewnum)
                    {
                        case 0 :
                            ((TextView)view).setText(questionList.get(question_number).getQuestion());
                            break;
                        case 1:
                            ((Button)view).setText(questionList.get(question_number).getOptionA());
                            break;
                        case 2:
                            ((Button)view).setText(questionList.get(question_number).getOptionB());
                            break;
                        case 3:
                            ((Button)view).setText(questionList.get(question_number).getOptionC());
                            break;
                        case 4:
                            ((Button)view).setText(questionList.get(question_number).getOptionD());
                            break;

                        //default:
                    }
                    if (viewnum !=0)
                        ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#F4E7B0")));


                    playAnim(view,1,viewnum);

                }

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        countdown.cancel();
    }
}
