# Simple Data Binding Example for Beginner in Android
## Description
  - Data Binding is a powerful library in Android that allows you to bind UI components such as TextViews, EditTexts, and Buttons to data sources in your       app's architecture. It's a way to simplify your code and make it more readable by removing the need for manual view binding.

  - With Data Binding, you can use expressions to transform data before displaying it in your UI, and even implement two-way data binding to update your  data sources when the user interacts with the UI. It also makes it easier to handle events such as button clicks or text changes, by allowing you to bind those events to methods in your code.

  - Data Binding works by generating binding classes at compile time, which allow you to access your UI components and data sources directly in your code. It's a powerful tool for Android developers that can greatly simplify the development process and make your code more maintainable.

## Table of Contents
  - [View Binding](https://developer.android.com/topic/libraries/view-binding)
  - [Data Binding](https://developer.android.com/topic/libraries/data-binding)
  - [Two Data Binding](https://developer.android.com/topic/libraries/data-binding/two-way)

## Screenshots
<img width="150" alt="Screen Shot 2023-03-27 at 11 10 37 PM" src="https://user-images.githubusercontent.com/29136735/227999987-a7fb7fa3-b659-4052-aa88-da1f0c150b02.png"> <img width="150" alt="Screen Shot 2023-03-27 at 11 11 56 PM" src="https://user-images.githubusercontent.com/29136735/228000334-ff0dd3b9-2a32-4717-b2f5-159e7954ea13.png"> <img width="150" alt="Screen Shot 2023-03-27 at 11 13 17 PM" src="https://user-images.githubusercontent.com/29136735/228000671-a4d102fc-8c34-4b57-8b27-8b796b1f52f1.png"> <img width="150" alt="Screen Shot 2023-03-27 at 11 16 23 PM" src="https://user-images.githubusercontent.com/29136735/228001395-e23a7c06-fc0a-40ac-aacc-cf99c293decc.png">

## Usage
 ### View Binding
 To enabled **View Binding** you have to add to ```app/build.gradle```
 ```
 android {
  ...
  buildFeatures {
        viewBinding true
    }
 }
 ```
 After view binding is enabled for a module, a binding class is generated for each XML layout file that the module contains. Each binding class contains  references to the root view and all views that have an ID. The name of the binding class is generated by converting the name of the XML file to Pascal case and adding the word "Binding" to the end.
 
 For example, consider a layout file called ```activity_view_binding.xml``` that contains the following:
 ```
<LinearLayout 
  ... >

    <TextView
        android:id="@+id/tv_result"
        ... />

    <EditText
        android:id="@+id/edt_a"
        ... />

    <EditText
        android:id="@+id/edt_b"
        ... />

    <Button
        android:id="@+id/btn_sum"
        ... />

</LinearLayout>
 ```
 The generated binding class is called ```ActivityViewBindingBinding```. This class has plenty fields: a TextView called ```tvResult```, two EditText called (```edtA```, ```edtB```) and a Button called ```btnSum```.

 ### How can I use it in Activity?
 
