package com.example.amaln.morsecode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_translate = findViewById(R.id.button);
        final EditText input_field = findViewById(R.id.editText);

        button_translate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_field_text = input_field.getText().toString();
                TextView output_field = findViewById(R.id.textView);

                String morse_code = translateToMorse(input_field_text);
                output_field.setText(morse_code);

            }
        });
    }

    public String translateToMorse(String input_field_text) {
        Map<Character, String> map = new HashMap<>();
        StringBuilder morse_code = new StringBuilder();

        map.put('A', ".-");
        map.put('B', "-...");
        map.put('C', "-.-.");
        map.put('D', "-..");
        map.put('E', ".");
        map.put('F', "..-.");
        map.put('G', "--.");
        map.put('H', "....");
        map.put('I', "..");
        map.put('J', ".---");
        map.put('K', "-.-");
        map.put('L', ".-..");
        map.put('M', "--");
        map.put('N', "-.");
        map.put('O', "---");
        map.put('P', ".--.");
        map.put('Q', "--.-");
        map.put('R', ".-.");
        map.put('S', "...");
        map.put('T', "-");
        map.put('U', "..-");
        map.put('V', "...-");
        map.put('W', ".--");
        map.put('X', "-..-");
        map.put('Y', "-.--");
        map.put('Z', "--..");

        for (int i = 0; i < input_field_text.length(); i++) {
            char upperChar = (char) (input_field_text.charAt(i) & 0x5f);
            String fetchedChar = map.get(upperChar);

            if (fetchedChar != null) {
                morse_code.append(map.get(upperChar));
            } else {
                morse_code.append(input_field_text.charAt(i));
            }

            morse_code.append(' ');
        }

        return morse_code.toString();
    }
}
