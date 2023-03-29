# Data/View Binding for Beginner in Android

## Description
  - View Binding is a lightweight library that generates a binding class at compile time, allowing you to easily access views in your app's layout files in a type-safe manner. It simplifies view access and eliminates the need for manual view binding, making your code more readable and maintainable.

  - Data Binding, on the other hand, is a more powerful library that goes beyond view access and allows you to bind UI components directly to data sources in your app's architecture. It allows you to use expressions to transform data and even implement two-way data binding, where changes made to the UI are automatically reflected in the data source and vice versa.

## Table of Contents
  - [View Binding](https://developer.android.com/topic/libraries/view-binding)
  - [Data Binding](https://developer.android.com/topic/libraries/data-binding)
  - [Two-Way Data Binding](https://developer.android.com/topic/libraries/data-binding/two-way)

## Screenshots
<img width="150" alt="Screen Shot 2023-03-27 at 11 10 37 PM" src="https://user-images.githubusercontent.com/29136735/227999987-a7fb7fa3-b659-4052-aa88-da1f0c150b02.png"> <img width="150" alt="Screen Shot 2023-03-27 at 11 11 56 PM" src="https://user-images.githubusercontent.com/29136735/228000334-ff0dd3b9-2a32-4717-b2f5-159e7954ea13.png"> <img width="150" alt="Screen Shot 2023-03-27 at 11 13 17 PM" src="https://user-images.githubusercontent.com/29136735/228000671-a4d102fc-8c34-4b57-8b27-8b796b1f52f1.png"> <img width="150" alt="Screen Shot 2023-03-27 at 11 16 23 PM" src="https://user-images.githubusercontent.com/29136735/228001395-e23a7c06-fc0a-40ac-aacc-cf99c293decc.png">

## Usage

### View Binding 
 
 ### I. Installation
  To enabled **View Binding** you have to add this snippet to ```app/build.gradle``` and then click sync
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
 
*NOTE: In xml best practice is to use Snake Case on `view_id` and View Binding will form `view_id` to Camel Case*

 ### II. I would like to ignore some of my xml files to be generated
 If you want a layout file to be ignored while generating binding classes, add the `tools:viewBindingIgnore="true"` attribute to the root view of that layout file:
 ```
 <LinearLayout
        ...
        tools:viewBindingIgnore="true" >
    ...
</LinearLayout>
 ```

 ### III. How can I use it in Activity?
 To set up an instance of the binding class for use with an activity, perform the following steps in the activity's `onCreate()` method:
 - Call the static `inflate()` method included in the generated binding class. This creates an instance of the binding class for the activity to use.
 - Pass the root view to `setContentView()` to make it the active view on the screen.
 
 These steps are shown in the following example:
 ```
 class ViewBindingActivity : AppCompatActivity() {
 
  private lateinit var binding: ActivityViewBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ...
    }
    
    ...
 
 }
 ```
 
 After you've followed the steps, here how you access views from xml in Activities
 ```
 class ViewBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListener()
    }

    private fun setupListener() {
        binding.btnSum.setOnClickListener {
            val a = binding.edtA.text.toString()
            val b = binding.edtB.text.toString()
            ...
        }
    }
    ...
}
 ```
 `binding` is represent your xml file, therefore every views which exist in xml will be visible by typing `binding.` it suppose to show the dropdown of views: 
 
 <img width="567" alt="Screen Shot 2023-03-29 at 11 19 11 AM" src="https://user-images.githubusercontent.com/29136735/228425776-39be68a7-c838-4494-a9df-e596dd4d676c.png">

 but don't forget to set `id` to views that you necessary to use in Activities or Fragments.
 
  *NOTE: Please check on `ViewBindActivity` for detail.*
  
  ### IV. Comparison to `findViewById`
  - *Null safety*: since view binding creates direct references to views, there's no risk of a null pointer exception due to an invalid view ID. Additionally, when a view is only present in some configurations of a layout, the field containing its reference in the binding class is marked with `@Nullable`.
  - *Type safety*: the fields in each binding class have types matching the views they reference in the XML file. This means there's no risk of a class cast exception.

  ### Limitation
  - *View binding* doesn't support [layout variables or layout expressions](https://developer.android.com/topic/libraries/data-binding/expressions), so it can't be used to declare dynamic UI content straight from XML layout files.
  - *View binding* doesn't support [two-way data binding](https://developer.android.com/topic/libraries/data-binding/two-way).
 
### Data Binding 

  ### I. Installation 
  To enabled **Data Binding** you have to add this snippet to ```app/build.gradle``` and then click sync
 ```
 android {
  ...
  buildFeatures {
        ...
        dataBinding true
    }
 }
 ```
  After `Data Binding` is enabled for a module, a binding class is not generated for each XML layout file yet it is not same to `View Binding`.
  
  ### II. How can I have my generated binding class
  First of all, you need to wrap your xml layout file in a `layout` tag: 
  `activity_data_binding.xml`
 ```
 <?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
  
    <data>

        ...

    </data>

    // Root layout
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        ...>

        ...

    </LinearLayout>

</layout>
 ```
  After this you could see generated binding class named `ActivityDataBindingBinding`. *Generated Binding Class* is similary to `View Binding`.
 
  *NOTE: If you decided to use `Data Binding` you should not use `View Binding` anymore. Because `Data Binding` takes place of `View Binding` already.*
 
  Here how it used in your Activities:
```
 class DataBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        ...
    }

    ...

}
```
 
 Or you can use same to `View Binding` case:
```
 class DataBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ...
    }

    ...

}
```
  Accessing views in xml on Activities or Fragments way the same to `View Binding` step.
  
  ### III. Why should I use `Data Binding` over `View Binding` if they're almost the same.
  Yeah!! good question.
  
  If you read `View Binding` content. You will see its limitation let read [here](https://github.com/thearith070/databinding#v-comparison-with-data-binding)
 
  
  
   
  
