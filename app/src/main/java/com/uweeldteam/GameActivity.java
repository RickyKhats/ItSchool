package com.uweeldteam;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class GameActivity extends AppCompatActivity {
    private byte partNum = -1;

    Fragment inventory;
    Fragment skillsTree;

    static class Part {
        Part(String text, String active, String passive, String neutral) {
            this.text = text;
            this.active = active;
            this.passive = passive;
            this.neutral = neutral;
        }

        String text, active, passive, neutral;
    }

    Part currentPart;

    ArrayList<Part> parts = new ArrayList<>();

    TextView text;
    Button positive, negative, neutral;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        text = (TextView) findViewById(R.id.text);
        positive = findViewById(R.id.active);
        negative = findViewById(R.id.passive);
        neutral = findViewById(R.id.neutral);
        positive.setTransformationMethod(null);
        negative.setTransformationMethod(null);
        neutral.setTransformationMethod(null);
        inventory = new Inventory();
        skillsTree = new SkillsTree();
        Init();
        Prologue();
    }

    void Init() {
        positive.setOnClickListener(v -> {
            if (partNum == 13) {
                Intent intent = new Intent(GameActivity.this, MainMenuActivity.class);
                startActivity(intent);
            } else
                NextPart();
        });
        negative.setOnClickListener(v -> {
        });
        neutral.setOnClickListener(v -> {
        });

        parts.add(currentPart = new Part("Сознание постепенно возвращалось ко мне, голова болела настолько сильно, что казалось будто она сейчас взорвётся.\n" +
                "Губы были сухие, казалось что я перебрал со спиртным.",
                "Продолжить",
                "",
                ""));
        parts.add(new Part("Я не ничего не помнил.\n" +
                "Слегка приподнавшись я почувствовал дикую боль, движения давались с очень большим трудом, что дало понять - резких движений делать не стоит.\n" +
                "Мне с трудом удалось приподняться, и опереться о ближайшую стену.",
                "Продолжить",
                "",
                ""));
        parts.add(new Part("Я огляделся.",
                "Продолжить",
                "",
                ""));
        parts.add(new Part("Я находился в комнате старого полуразваленного дома, моё внимание сразу привлекла полулитровая бутылка воды.",
                "Продолжить",
                "",
                ""));
        parts.add(new Part("Кое-как добравшись к столу я схватил бутылку, и открыл её, и выпил всю воду залпом.",
                "Продолжить",
                "",
                ""));
        parts.add(new Part("Вдруг я услышал треск, звук доносился из другой комнаты.\n" +
                "Я приподнялся и с осторожностью заглянул туда.",
                "Продолжить",
                "",
                ""));
        parts.add(new Part("Это была спальня, а на тумбочке лежал дозиметр. Он показывал лёгкий уровень излучения.\n" +
                "Рядом с ним были ключи с брелком, но текст на нём был затёрт.",
                "Продолжить",
                "",
                ""));
        parts.add(new Part("Я взял ключи и дозиметр.\n" +
                "Осмотреться в этом случае было бы лучшей идеей, с тяжестью я добрался до окна, и выглянул в него.",
                "Продолжить",
                "",
                ""));
        parts.add(new Part("Оно выходило на задний двор.\n" +
                "Было видно маленький участок, за которым был лес.",
                "Продолжить",
                "",
                ""));
        parts.add(new Part("Я прошёл обратно в комнату, где проснулся, и огляделся, я заметил деревянный люк с навесным замком.\n" +
                "Моя голова не придумала ничего лучше, чем спуститься вниз. Я открыл замок, и снял его.",
                "Продолжить",
                "",
                ""));
        parts.add(new Part("Под досками было несколько спаянных металлических пластин, и поднять люк составило больших усилий.\n" +
                "Вниз уходила лестница, а на люке снизу висел фонарь.",
                "Продолжить",
                "",
                ""));
        parts.add(new Part("Я снял фонарь одновременно включив его и осветил спуск.\n" +
                "Внизу была приоткрытая массивная металлическая дверь.",
                "Продолжить",
                "",
                ""));
        parts.add(new Part("Я решил спуститься, и спустившсь я открыл дверь и вошёл в помещение.\n" +
                "Это было бомбоубежище.\n" +
                "Я закрыл за собой дверь, и осмотрелся получше, рядом был стеллаж с консервами.",
                "Продолжить",
                "",
                ""));
        parts.add(new Part("Продолжение следует...",
                "Выйти",
                "",
                ""));
    }

    void DrawCurrentPart() {
        text.setText(currentPart.text);
        positive.setText(currentPart.active);
        negative.setText(currentPart.passive);
        neutral.setText(currentPart.neutral);
    }

    void Prologue() {
        NextPart();
    }

    void NextPart() {
        partNum++;
        currentPart = parts.get(partNum);
        DrawCurrentPart();
    }

    void Jump(int part) {
        currentPart = parts.get(part);
        DrawCurrentPart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {

    }
}