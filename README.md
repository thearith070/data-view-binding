# Simple Data Binding Example for Beginner in Android

### Table of Contents
  #### I. [View Binding](https://developer.android.com/topic/libraries/view-binding)
  - View Binding is another library in Android that simplifies the process of accessing views in your app's layout files. 
  It generates a binding class at compile time, which allows you to access your views directly in your code, 
  without the need for manual view binding.
  
  - With View Binding, you can easily access views in your layout files and manipulate them in your code,
  without having to use *findViewById()* or manually bind views to variables. 
  This can greatly simplify your code and make it more readable and maintainable.
  
  #### II. [Data Binding](https://developer.android.com/topic/libraries/data-binding)
  - Data Binding is a powerful library in Android that allows you to bind UI components such as *TextViews*, *EditTexts*, and *Buttons*
  to data sources in your app's architecture. It's a way to simplify your code and make it more readable by removing the need for manual view binding.
  
  - With Data Binding, you can use expressions to transform data before displaying it in your UI, 
  and even implement two-way data binding to update your data sources when the user interacts with the UI. 
  It also makes it easier to handle events such as button clicks or text changes, by allowing you to bind those events to methods in your code.
  
  #### III. [Two Data Binding](https://developer.android.com/topic/libraries/data-binding/two-way)
  - Two-way data binding in Android allows you to establish a two-way communication between a UI component and a data source, 
  so that changes made to the UI component are automatically reflected in the data source, and changes made to the data source are automatically 
  reflected in the UI component.
  
  - This means that you don't have to manually update your UI when the data changes, or vice versa, 
  because the two-way data binding mechanism takes care of it for you.
  
  - Two-way data binding is implemented using the @={} syntax in the binding expression. When you use this syntax, 
  the data flows in both directions - from the data source to the UI component, and from the UI component back to the data source.
