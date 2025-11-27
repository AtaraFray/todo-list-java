 Todo List Application – Java
זוהי מערכת בסיסית של ניהול משימות בשפת java - בכתיבה פשוטה ןבסיסית מבלי להשתמש בספריות חיצוניות .
המערכת מנהלת את רשימת המשימות באמצעות קובץ json - קריאה וכתיבה באופן ידני !

 מבנה המחלקות :
Task Class:
מייצגת משימה במערכת .
fields :
- id
- title
- description
- status (Enum)

 TaskRepository
אחראית על שמירת המשימות לקובץ JSON וטעינתן ממנו.

 API methods:
void addNewTask(Task task)
boolean updateTask(int taskId, Task updatedTask)
void delete(int taskId
Task getTaskById(int taskId)
Map<Integer, Task> listAll()

file handle method:   
public static Map<Integer, Task> loadTasksFromFile()
פונקציה שטוענת מידע מקובץ json מקומי 
הפונקציה מכניסה את תוכן הקובץ לאובייקט מסוג מחרוזת ,
עוברת עליו מורידה תווים מיותרים כמו צומדיים וכדו' ומכניסה את כל הערכים למבנה נתונים . 
private void saveTasksToFile() 
פונקציה ששומרת מידע ששונה נוצר ונמחק לקובץ הjson
הפונקציה עובדת באותה הדרך מכניסה את כל המבנה נתונים בעזרת שרשור למחרוזת 
ומכניסה את הנתונים לקובץ המקומי !

 TaskService
אחראית על לוגיקה העסקית של המערכת (BLL) .
method : 
public void markTaskDone(int taskId)
 סימון משימה כ־DONE .
public Task findTaskByText(String text)
חיפוש משימות לפי טקסט המופיע ב־title או description .
public List<Task> sortTaskByStatus()
 מיון רשימת משימות לפי status 

 Main
מחלקת ההפעלה של המערכת.

מכילה UI בסיסי (מבוסס קונסול) שמדגים:
- יצירת משימות
- עדכון משימות
- מחיקת משימות
- חיפוש משימות
- הצגת כל המשימות
- סימון משימה כ־DONE

הפעלת המערכת 

1. פותחים את הפרויקט ב־IDE (כמו IntelliJ / Eclipse)
2. מריצים את מחלקת Main
3. עובדים דרך התפריט הבסיסי המוצג בקונסול


 טכנולוגיות

- Java Standard Edition  
- ללא ספריות חיצוניות  
- עבודה עם קובץ JSON לשמירת נתונים
- וכמובן ניהול גירסאות בgithub



 הערות

- דגש על קוד קריא, מופרד למחלקות ומאורגן נכון (Clean Code)
- המערכת בנויה כך שניתן להרחיב אותה בקלות בהמשך 
מקווה שתהנו :)