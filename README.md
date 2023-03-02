<h1>Unit Converter</h1>
<p>Jetpack Compose app built based on MVVM architecure (ViewModel, Jetpack Navigation, Dagger2, Room, Coroutines, Flow)
</p>
<br>

<!-- Screenshots -->
<h2>Screenshots</h2>
<p align="center">
  <img src="https://user-images.githubusercontent.com/57670625/222523127-8eff58c3-a9f3-4ea7-af25-1cd5f085d3db.png" width="23%"/>
  &nbsp; &nbsp;                                                                                                                     
  <img src="https://user-images.githubusercontent.com/57670625/222523126-b2b02cc5-eb89-4588-9564-025f5868ad7c.png" width="23%"/>
  &nbsp; &nbsp;
  <img src="https://user-images.githubusercontent.com/57670625/222523124-d69f9086-4ca1-4cd7-9920-90a07227ae54.png" width="23%"/>
</p>
<br>

<!-- Tech Stack -->
<h2>Tech Stack</h2>
<ul>
<li>Minumum SDK Level: 21</li>
<li>100% Kotlin</li>
<li>Architecture
    <ul>
      <li><a href="https://developer.android.com/topic/architecture">MVVM Pattern</a>: Industry-recognized software architecure pattern supported by Google</li>
    </ul>
 </li>
 <li>Jetpack
  <ul>
    <li><a href="https://developer.android.com/jetpack/compose">Compose</a>: Android's recommended modern toolkit for building native UI</li>
    <li><a href="https://developer.android.com/topic/libraries/architecture/viewmodel">ViewModel</a>: Exposes data streams as a state holder</li>
    <li><a href="https://developer.android.com/training/data-storage/room">Room</a>: Data Object Mapping library providing an abstract layer over SQLite</li>
    <li><a href="https://developer.android.com/jetpack/compose/navigation">Navigation</a>: Supports implementing navigation through multiple fragments</li>
    <li><a href="https://developer.android.com/training/dependency-injection/hilt-android">Hilt</a>: Dependency injection library built on top of Dagger benefit from the compile-time correctness, runtime performance, scalability, and Android Studio support </li>
  </ul>
</li>
<li><a href="https://developer.android.com/kotlin/coroutines">Coroutines</a>: Concurrency design pattern provided by Kotlin</li>
<li><a href="https://developer.android.com/kotlin/flow">Flow</a>: Asynchronous data stream that sequentially emits values and completes normally or with an exception</li>
</ul>
<br>

<!-- Architecture -->
<h2>Architecture</h2>
<p>Top News app was built with Google's recommended modern app architecture - MVVM pattern. By separating multiple app components into three layers
- UI, Domain and Data, the app is scalable, maintainable and testable.</p>
<ul>
  <li>Architectural Principles</li>
    <ul>
      <li>Separations of concerns</li>
      <li>Drive UI from data models</li>
      <li>Single source of truth</li>
      <li>Unidirectional Data Flow</li>
   </ul>
</ul>
<p align="center">
   <img src="https://user-images.githubusercontent.com/57670625/221630274-a9214a21-5908-4725-b799-800197555750.jpg"/>
</p>

<h3>Architecture Overview</h3>
<p>Top News is composed with three different layers - UI layer, domain layer and data layer. Each layer has app components which have different responsibilities.</p>

<h3>UI Layer</h3>
<p align="center">
   <img src="https://user-images.githubusercontent.com/57670625/221978991-caae1ffb-69e2-48c3-b9fd-0262c6cce87b.jpg"/>
</p>
<p>UI layer displays the application data and serves as the primary point for user interactions. Whenever the app data changes, the UI should update to reflect changes made by either user interaction or external input.</p>
<ul>
  <li>The main activity and all the fragments - Feed, Browse, Saved, etc are UI elements and they display articles received from network requests and the database</li>
  <li>NewsViewModel holds state and plays as a bridge between UI elements and the data layer</li>
  <li>UI elements request actions to ViewModel and observer ViewModel's livedatas to automatically update screens</li>
</ul>

<h3>Domain Layer</h3>
<p align="center">
   <img src="https://user-images.githubusercontent.com/57670625/221953741-1c9dd925-1dc3-47d7-a6c2-d50c2efd0fba.jpg"/>
</p>
<p>Domain layer is optional layer for the modern architectural pattern. However, when the app is a large scale app and has complex functionalities, the domain layer helps to avoid code duplications and improves readability of codes. Top News has seven main use cases and these classes fit between ViewModel and the data layer(Repository).</p>


<h3>Data Layer</h3>
<p align="center">
   <img src="https://user-images.githubusercontent.com/57670625/221978988-f2193bf4-f1f1-43f8-a021-34ee6cd0f500.jpg"/>
</p>
<p>Data layer is reponsible for containing application data and business logics. The data layer is consisted of repositories and data sources. It is important to keep each repository as a single source of truth.</p>
<ul>
  <li>NewsRepository is a single source of truth and requests data from NewsLocalDataSource and NewsRemoteDataSource.</li>
  <li>NewsLocalDataSource is a class managing the database built with Room library and NewsRemoteDataSource is a class requesting network response to NewsAPI server.</li>
</ul>
<br>

<!-- Open APIs -->
<h2>Open APIs</h2>
<p>Top News using the <a href="https://newsapi.org//">NewsAPI</a> for fetching JSON object from the server. News API provides articles and breaking news headlines from news sources and blogs across the web with JSON API.</p>
 
