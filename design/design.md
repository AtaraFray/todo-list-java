#### &nbsp;                                                                                                                                                                                                                                                                                                    **Design**

##### Library Classes  :

##### &nbsp;   ***Book***

###### **Fileds**: 

int bookId;

String bookTitle;

String author;



###### **Endpoints  :**

Get all books from db .

*GET ( books/)*

Get one book from db by bookID .

*GET ( books/{id}/)*

Add a new book to book list in db .

*POST ( books/ )*

Edit / update a book by searching the book by bookId .

*PUT ( books/{id}/)*

Delete book by searching the book by bookId .

*DELETE ( books/{id})*



###### <b>Actions </b>:

Search book by prameters .   

Check if the book exist and not borrowed .                



#####    **User**

###### **Fileds** :

String userId ; 

String userFullName ;

String amail ;



###### **Endpoints  :**

Get all users from db .

 *GET (users/)*

&nbsp;Get user by userId .

 *GET  ( users/{id}/)*

&nbsp;Add a new user .

  *POST ( users/)* 

&nbsp;Edit/update user by userId .

 *PUT ( users/{id})*

Delete user by userId  

*DELETE (users/{id})*

###### <b>Actions</b> :

&nbsp;Check if user return the book on time , if not he need to pay :)



##### **Borrow**

###### **Fileds** :

&nbsp;int borrowNumber ;

&nbsp;int bookId ;

&nbsp;String userId ;

&nbsp;Date dateOfBorrowed ;

&nbsp;Date dateOfReturn ;

###### **Endpoints  :**

Get all borrow from server   

 *GET (borrows/)*      

Update borrow dates -  when user return a book or borrowed book .

*POST  (borrows/)*



###### **Actions** :

&nbsp;Search if book exsit or it borrowed .



##### &nbsp;Order and payment

###### **Classes**  :

**Class Order  {**

---

String orderId ;

String  userId ;

int  ammountOfProducts ;

Boolean ifPaid ;



###### **}**

&nbsp;            

###### **Actions  :** 

Save order details .

&nbsp;Make sure that order was paid  .



###### **Class Paymant  {**



String paymantId ;

String  orderId ;

int  ammount ;

String wayToPay ; //  visa , cash ect



###### **}**



Actions :

&nbsp;To save the details of payment method .



**הסבר כיצד ניתן יהיה לדעת שההזמנה שולמה :**

כאשר תיווצר הזמנה - 
יווצר גם אופן התשלום , 

במחלקה תשלום יהיה מפתח זר שהוא מספר הזמנה 
כך שכל תשלום יצביע על ההזמנה שעבורה שולם

מפתח הזמנה ביחד עם תשלום יוצר את המפתח היחודי של תשלום + הזמנה ! 
          