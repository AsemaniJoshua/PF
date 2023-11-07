package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    Scanner scanner = new Scanner(System.in);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("LEARN C++");
    }

    public void Start(View v){
        v.setEnabled(true);
        Log.d("Start", "Enabled");
        Button button = (Button) v;
        button.setText("Starting ...");
       TextView textView = findViewById(R.id.textView4);
       // or
        //((TextView)findViewById(R.id.textView4).setText(" Welcome .........");
       textView.setText(" Welcome ............");
        View vv = findViewById(R.id.Output);
        TextView t = (TextView) vv;
        t.setVisibility(View.INVISIBLE);
        Toast.makeText(this," Thank you for downloading the app", Toast.LENGTH_LONG).show();
        Intent MissionAndVission = new Intent(this,MissionAndVission.class);
        EditText editText = (EditText) findViewById(R.id.Userinput);
        String name = editText.getText().toString();
        MissionAndVission.putExtra("Terms", name + "By clicking on continue, You have agree to our terms and conditions");
        startActivity(MissionAndVission);
    }

    public void Website(View v){
        v.setEnabled(false);
        Log.d("Website", "Visiting the website");
        Button button = (Button) v;
        button.setText("Wait for a second ...");
        Log.d("Website", " Re-directing to Website");

    }

    public void Input( View v){
        v.setVisibility(View.INVISIBLE);
        //TextView input = findViewById(R.id.Userinput);
        // or
         EditText input = findViewById(R.id.Userinput);
        String name = input.getText().toString();
        Log.d("UsernameButton",name);
        Afterinput(input,name);
        Button Startbutton = (Button) findViewById(R.id.button2);
        Startbutton.setVisibility(View.VISIBLE);
    }
    public  void Afterinput(EditText v,String name){
        v.setVisibility(View.INVISIBLE);
       View vv = findViewById(R.id.Output);
        TextView textView = (TextView) vv;
        textView.setVisibility(View.VISIBLE);
        textView.setText(" Hello " + name + "," + "\n Click on the start button to continue");

    }

    /*

    Topics of this course :

    Java vs Kotlin

 Multiple points of entry :

     pages = Activities

     Fragments

     Intents

     Layouts - Constraint Layouts

     Views

     Id

     FindViewsById(R.id.Idname)

     Click Handler(methods to be executed when u click a view) = defined in attributes of XML

     View v ----- (as parameter)

     Log d

     Toast

      
    NB: 1. Methods Starts and Websites are events handlers.
    2. Log.d helps u to know if any view is being clicked or not in your logcat.
    3. setEnabled conditions that, after clicking on a button or any other view, it should maintain as
    it is or not.
     4. (Button) v means that u are converting the View class to the Button class. NB: the same
     applies to other types of Views(TextView,Button, and others).


       Getting user inputs.
       method input,Afterinput and Start.
       NB: You must import android.widgets.EditView.

       creating an alert
       Toast.makeText(this," String of text or variable name",Toast.LENGTH_LONG).show();
       NB: "this" refers to the current activity or activity to display the Toast message
            "Toast.LENGTH_LONG" refers to time the Toast message will last.
            " .show()" displays the Toast message.
            You must import android.widgets.Toast.



            INTENTS
       Intent simply means that, when you click on a view in a certain activity it should take you
       to another activity.

       To create an activity :

       Go to File > New > Activity > Empty Activity > Type the name of your activity.
                                           OR
       Right click on the MainActivity in your project folder in your android studio > New >
        Activity > Empty Activity > Type the name of your activity.

       E.g: if you want that when you click on start button it should take u to another
       activity, then type this in the start button event handler.

       Intent variablename = new Intent(this, activity you want to go.class);
       startActivity(variablename);

       "this" means the activity in which the start button can be found.
       "activity you want to go.class" means that activity u want to go. NB: Every activity is a
class.
        "startActivity(variablename)" means start that activity u want to go.

        DESIGNING ACTIVITY

NB: constraint layout is the parent layout.
    You must anchor every view otherwise it will jup to (0,0) when u run it.
    You can anchor a view to either the parent layout or other views.
    You can add a different constraint layout to a default constraint layout.
    Fragment is like a minimal constraint layout that will appear on every Activity.

    HARDCODED TEXT

To prevent hardcoded text, open your project folder > src > main > res > values > strings.xml >
open editor > click on + to add a variable name which will store the value u want to display not to
be hardcoded > type the variable name in the key tab and type the string u do not want it to be
hardcoded in the default tab > click on kk > type the variable name u typed in the key tab in the
text tab an the attribute side of the activity u want. NB: The value of the variable name u typed
will display in the layout of the design mode.


HOW TO MAKE A PARTICULAR ACTIVITY THE MAIN ACTIVITY OTHER THAN THE DEFAULT ONE.


       In the project folder in your IDE > Main > select AndroidManifest.xml > cut and paste
       <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
       beneath the activity tag u want it to be the MainActivity(the activity that will launch
       when u open your app) and set android:exported to "true" and close the android tag (i.e
       <activity></activity>. NB: The code that will make an activity to be Main(refer to intent tag)
        must be between the activity tag.

HOW TO TITLE OR GIVE A HEADER TO YOUR ACTIVITIES IN UR APP.

        In the project folder in your IDE > Main > select AndroidManifest.xml > Search for an
        activity tag with an attribute called "android:name" that has a value of the activity u
        like to give a title or header.
        Add an attribute that will set that title or header which is "android:label" and give it a
        value(the title) u want to name that activity in your app.

        NB: If you label the launcher activity( the activity that will open first when u launch
        your app), that label will be the same as your app name. To avoid this, write
         "setTitle("label u want to give that activity")" in the default method( @Override
    protected void onCreate(Bundle savedInstanceState) ) so that the setTitle will be the activity
    Title and android:label will be the app name.

        You can also use the setTitle in the non launcher activities java default method and it
        will work and avoid the android:label.

        You can also change the your app icon and round icon in AndroidManifest.xml


   BACKWARDS NAVIGATION TO OTHER ACTIVITIES

This simply means that bringing a back arrow(<--) on an activity( usually on the top) so that when
the user click on it, it will send the person back to the main activity. E.g: back arrows in games.
           In the project folder in your IDE > Main > select AndroidManifest.xml > In the
activity tag of the activity u want to bring the back button type " android:parentActivityName =
".MainActivity" "
            The above simply means that, when u click on the back symbol(<--) it should send u back
to MainActivity.  NB: U can change the MainActivity and make it a different activity so that when
the user press the back symbol(<--) it will send the person back to that different activity the
programmer used in place of the MainActivity.
             Do not forget the "." before every parentActivityName u want to use.


   PASSING DATA FROM ONE ACTIVITY TO THE NEXT ACTIVITY

To pass data from one activity to the other is done by typing :
     Intent MissionAndVision = new Intent(this,MissionAndVision.class);
     MissionAndVision.putExtra(name:"Terms",value:"By clicking on continue, You have agree to our terms and
     conditions");
        startActivity(MissionAndVision);

NB: When u use ".putExtras" instead of "".putExtra", it will take Bundle which is the collection of
different Extras.

NB: "MissionAndVision.putExtra" means u want to add things to the intent activity straight from
 your current activity.
 " name:"Terms" " refers to the key(which is the same as tag in Logcat)which will be used to access
      the content u want to pass from the current activity to the intent activity.

      To get the content u want to pass from the current activity to the intent activity, type this
      in the @override onCreate method of the intent activity.
              intent MissionAndVision = getIntent() ;
              MissionAndVision.getStringExtra(name:"Terms");
              String message = MissionAndVision.getStringExtra(name:"Terms");
              Textview textview = (Textview) findViewById(R.id.PassedMessageFromDifferentActivity);
              textview.setText(message);

NB: intent MissionAndVision = getIntent means u want to get the intent u declared in the current
activity(this).

MissionAndVision.getStringExtra(name:"Terms") means u want to get the extra with the key(Tag) "Terms.

String message = MissionAndVision.getStringExtra(name:"Terms") means u want to store the gotten
extra in a variable name "message".

Textview textview = (Textview) findViewById(R.id.PassedMessageFromDifferentActivity) means u want to
find a view in that intent activity and convert that view to its specific type.

textview.setText(message) means u want the chosen view to display the extra value u stored in the
variable name "message".

You can also use variable name or the value of a view as the key(Tag) value in MissionAndVision.putExtra.
To do the above, u must type the following in  the current activity( that is when u are using the
value of a view as the key(Tag) value in MissionAndVision.putExtra.)
E.g: Getting the name the user inputted in the MainActivity and passing it as the key(Tag) value in
MissionAndVision.putExtra.

            IN THE CURRENT ACTIVITY:

        Intent MissionAndVision = new Intent(this,MissionAndVision.class);
        EditText editText = (EditText) findViewById(R.id.Userinput);
        String name = editText.getText().toString();
        MissionAndVision.putExtra("Terms", name + "By clicking on continue, You have agree to our terms and conditions");
        startActivity(MissionAndVision);

NB: You do not need to type anything in the intent activity(except the previous one that u typed)
because when u get the key(Tag) in the intent activity, it will automatically display its value.


REMOVING OR DELETING AN ACTIVITY.

           In the project folder in your IDE > src > Main > java > Right click on the activity u
want to delete > select "Find usages".
NB: This will help u to know wherever u have use that activity (e.g: AndroidManifest.xml). By
double clicking on the usages, it will take u directly to where u used that activity and u will
delete that part from your code before u delete the actually activity to prevent errors.

You must also go to where u can prevent hardcoded text

 ( open your project folder > src > main > res > values > strings.xml)

to delete that activity if it is there because the "Find usages" will not show u that part.

          After the above, In the project folder in your IDE > src > Main > java > Right click on
the activity u want to delete > select "Delete".
NB: If u delete an activity, u must also delete its XML File.


CREATING NEW PROJECT FOLDER

You can create a new project folder by Going to File > New > New Project > select whatever template
u like e.g: Bottom Navigation Activity Template > Next > Give your project a name and select java
as your language > select your API that u want( always select the one which is a bit low so that all
android users can use it.


OTHER FORMS OF TEXT PALETTE

       Some other forms of the Textview palette are Textview, PlainText, Password, Password Numeric,
email, Multiline Text, Auto complete Textview, multiAuto complete Textview, etc.

NB: Multiline Text, Auto complete Textview and multiAuto complete Textview will work like the
message tab in whatsapp where by all the text are wrapped when they get to the end of the tab.



    */
}