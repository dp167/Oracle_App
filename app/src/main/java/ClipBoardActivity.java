

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.browserapp.R;

/*
public class ClipBoardActivity extends AppCompatActivity {

    Button AnswerButtonObject;

    AnswerButtonObject = (Button) findViewById(R.id.answer_button);

    AnswerButtonObject.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Get clip data from clipboard.
            ClipData clipData = (ClipData) ClipboardManager.getPrimaryClip();
            // Get item count.
            int itemCount = clipData.getItemCount();
            if(itemCount > 0)
            {
                // Get source text.
                Item item = clipData.getItemAt(0);
                String text = item.getText().toString();

                // Set the text to target textview.
                destTextView.setText(text);

            }
        }
    });


}
*/