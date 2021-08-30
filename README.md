Android – Coding Challenge (TMobile)

You will be developing a native application for home page feeds. This page displays current feeds in various forms like text, image or combination of both.

Below are the details needed to construct a sample native application based on a public REST API.

API
A sample REST API that returns a list of pre-defined result:
“https://private-8ce77c-tmobiletest.apiary-mock.com/test/home”

The API returns a list of view models to be rendered as a list-view.


Requirements
These requirements are rather high level and vague. If there are details omitted, it is because we will be happy with any of wide variety of solutions/creativeness. Don’t worry about finding “the” solution. 

DONE - 1.	Query the rest API for receiving the home page response.

DONE - 2.	Display the data by constructing a list view.

DONE - 3.	The view(s) should dynamically set the height based on the content.

DONE - 4.	All texts in the view(s) should be displayed (no truncation)

DONE - 5.	The view(s) which have image should set the height dynamically based on image resolution in the API response.
Ex: Images in the API response can be a rectangle (higher width/ higher height) or square.

DONE - 6.	All image + text models should be rendered with UI hierarchy as below:
•	Image will take the entire RecyclerView
•	Texts will be displayed on top of the ImageView beginning from bottom of the RecyclerView

Example of image+text

 ![alt text](https://i.ibb.co/MVYhsM0/tmobile-img.png)

What is Important
✔️	Proper functionality, requirements met.

✔️	Coding should be in Kotlin Programming language

✔️	Compose UI should be used for constructing UI layers

✔️	Well-constructed, easy-to-follow, commented code (especially comment hacks or workarounds made in the interest of expediency (i.e. // given more time I would prefer to wrap this in a blah blah blah pattern blah blah)).

✔️	Proper separation of concerns, best-practice coding patterns

✔️	View Models Unit test case

✔️	Compose UI instrumentation test case 

Bonus Points!
Handle offline mode (when network is not available, if data from previous open instance of app is available use that to render the page)
