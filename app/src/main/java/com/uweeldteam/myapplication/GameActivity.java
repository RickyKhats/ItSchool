package com.uweeldteam.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    private byte partNum = -1;


    public static class Part {
        Part(String text, String active, String passive, String neutral) {
            this.text = text;
            this.active = active;
            this.passive = passive;
            this.neutral = neutral;
        }

        public String text, active, passive, neutral;
    }

    Part currentPart;
    ArrayList<Part> currentQuest = new ArrayList<>();

    ArrayList<Part> prologue = new ArrayList<>();
    ArrayList<ArrayList<Part>> quests = new ArrayList<>();

    TextView text;
    Button positive, negative, neutral;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        text = findViewById(R.id.text);
        positive = findViewById(R.id.positive);
        negative = findViewById(R.id.negative);
        neutral = findViewById(R.id.neutral);
        positive.setTransformationMethod(null);
        negative.setTransformationMethod(null);
        neutral.setTransformationMethod(null);
        Init();
    }

    void Init() {


        prologue.add(currentPart = new Part("Сознание постепенно возвращалось ко мне, голова болела настолько сильно, что казалось будто она сейчас взорвётся.\n" +
                "Губы были сухие, казалось что я перебрал со спиртным.",
                "Встать",
                "",
                ""));
        prologue.add(new Part("Я не ничего не помнил.\n" +
                "Слегка приподнавшись я почувствовал дикую боль, движения давались с очень большим трудом, что дало понять - резких движений делать не стоит.\n" +
                "Мне с трудом удалось приподняться, и опереться о ближайшую стену.",
                "Огладеться",
                "",
                ""));
        prologue.add(new Part("Я огляделся.",
                "Продолжить",
                "",
                ""));
        prologue.add(new Part("Я находился в комнате старого полуразваленного дома, моё внимание сразу привлекла полулитровая бутылка воды.",
                "Подойти к столу",
                "",
                ""));
        prologue.add(new Part("Кое-как добравшись к столу я схватил бутылку, и открыл её, и выпил всю воду залпом.",
                "Продолжить",
                "",
                ""));
        prologue.add(new Part("Вдруг я услышал треск, звук доносился из другой комнаты.\n" +
                "Я приподнялся и с осторожностью заглянул туда.",
                "Продолжить",
                "",
                ""));
        prologue.add(new Part("Это была спальня, а на тумбочке лежал дозиметр. Он показывал лёгкий уровень излучения.\n" +
                "Рядом с ним были ключи с брелком, но текст на нём был затёрт.",
                "Взять",
                "",
                ""));
        prologue.add(new Part("Я взял ключи и дозиметр.\n" +
                "Осмотреться в этом случае было бы лучшей идеей, с тяжестью я добрался до окна. На нём было отверствие. Я выглянул в него.",
                "Продолжить",
                "",
                ""));
        prologue.add(new Part("Оно выходило на задний двор.\n" +
                "Было видно маленький участок, за которым был лес.",
                "Вернуться в комнату",
                "",
                ""));
        prologue.add(new Part("Я прошёл обратно в комнату, где проснулся, и огляделся, я заметил деревянный люк с навесным замком.\n" +
                "Моя голова не придумала ничего лучше, чем спуститься вниз. Я открыл замок, и снял его.",
                "Продолжить",
                "",
                ""));
        prologue.add(new Part("Под досками было несколько спаянных металлических пластин, и поднять люк составило больших усилий.\n" +
                "Вниз уходила лестница, а на люке снизу висел фонарь.",
                "Взять фонарь и спуститься",
                "Не спускаться",
                ""));
        prologue.add(new Part("Я решил спуститься, и спустившсь я открыл дверь и вошёл в помещение.\n" +
                "Это было бомбоубежище.\n" +
                "Я закрыл за собой дверь, и осмотрелся получше, рядом был стеллаж с консервами.",
                "Взять консервы",
                "",
                ""));
        prologue.add(new Part("С жадностью я схватил консевы и проколов их ключом кое-как открыл их.",
                "Съесть консервы",
                "",
                ""));
        prologue.add(new Part("Чуть-ли не вылизав банку я убрал её обратно на стеллаж",
                "Оглядеться",
                "",
                ""));
        prologue.add(new Part("На столе, который был в другом конце комнаты лежал блокнот",
                "Подойти",
                "",
                ""));
        prologue.add(new Part("Подойдя поближе я взял блокнот. Это был дневник",
                "Открыть на первой странице",
                "",
                ""));
        prologue.add(new Part("17 Марта.\n" +
                "Радио больше не работает. Неизвестно что происходит сверху, но слышны взрывы. \n" +
                "Мне нужно выбраться наверх, и посмотреть что там происходит, но делать это сейчас - не лучшая идея\n" +
                "Попробую ночью. Благо часы всё ещё работают\n" +
                "8 часов. Через пару часов думаю буду выходить.\n",
                "Перелистнуть страницу",
                "",
                ""));
        prologue.add(new Part("Я вернулся. Я вышел на улицу, и прошёл пару кварталов. Счётчик гейгера показывал средний уровень опасности.\n" +
                "Мне кажется я нахватался излучения. Сильно тошнит.\n\n" +
                "Дальше текст был очень неразборчивым. Что произошло?",
                "Продолжить",
                "",
                ""));
        prologue.add(new Part("Что-ж. Мы имеем - взрывы, радиацию, и отверстие в окне, предположительно от выстрела. Только трупа нет.",
                "Осмотреться",
                "",
                ""));

        prologue.add(new Part("Маленький столик. Стеллаж с разными вещами, и едой. Массивная металлическая дверь. Нужно проверить закрыл ли я её.",
                "Открыть дверь",
                "",
                ""));
        prologue.add(new Part("Дверь закрыта, в комнате больше нет ничего интересного",
                "Лечь отдыхать",
                "Открыть дверь",
                ""));
        prologue.add(new Part("Я прилёг на кровать и закрыл глаза. Буквально сразу я погрузился в сон...",
                "Продолжить",
                "Лечь отдыхать",
                ""));
        prologue.add(new Part("Продолжение следует...",
                "В главное меню",
                "",
                ""));
        quests.add(prologue);

        ArrayList<Part> end1 = new ArrayList<>(), end2 = new ArrayList<>();
        end1.add(new Part("Я решил остаться и выйти на улицу. Услышав выстрел я не сразу понял что произошло. В глазах потемнело",
                "Продолжить",
                "",
                ""));

        end1.add(new Part("Вас настигла смерть. В этом мире правит только жажда выжить.",
                "В главное меню",
                "",
                ""));

        end2.add(new Part("Я приоткрыл дверь. На меня сразу же наставил пистолет человек в противогазе.",
                "Отойти от двери",
                "",
                ""));

        end2.add(new Part("Выстрел. В глазах потемнело. Я услышал лишь \"Прости...\"",
                "Продолжить",
                "",
                ""));

        end2.add(new Part("Вас настигла смерть. В этом мире правит только жажда выжить.",
                "В главное меню",
                "",
                ""));
        quests.add(end1);
        quests.add(end2);

        Prologue();

    }

    void DrawCurrentPart() {
        text.setText(currentPart.text);
        positive.setText(currentPart.active);
        negative.setText(currentPart.passive);
        neutral.setText(currentPart.neutral);
    }

    void Prologue() {
        currentQuest = quests.get(0);
        NextPart();
    }


    void NextPart() {
        partNum++;
        currentPart = currentQuest.get(partNum);
        DrawCurrentPart();
    }

    void Jump(int quest, int part) {
        currentQuest = this.quests.get(quest);
        Jump(part);
    }

    void Jump(int part) {
        partNum= (byte) part;
        currentPart = currentQuest.get(partNum);
        DrawCurrentPart();
    }


    public void Init1(View view) {
        if (currentPart.active.equals("В главное меню")) {
            Intent intent = new Intent(GameActivity.this, MainActivity.class);
            startActivity(intent);
        } else {
            NextPart();
        }
    }

    public void Negative1(View view) {
        if (currentPart.passive.equals("Не спускаться")) Jump(1, 0);
        if (currentPart.passive.equals("Открыть дверь")) Jump(2, 0);
    }

    @Override
    public void onBackPressed() {
    }
}
