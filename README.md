# ✅ Java Swing To-Do List Application

## 📌 What is this?

This is a **To-Do List desktop application** built using **Java Swing**.
It helps users manage daily tasks by allowing them to add, complete, and delete tasks in a simple and interactive interface.

The main goal of this project was to learn how real-world desktop applications work, especially focusing on UI design and user interaction.

---

## ⚙️ How I Built It

I developed this project using:

* Java Swing for GUI components
* AWT for layouts and styling
* Event Handling for user interactions

### Key Implementation

* Created a custom `Task` class to store task data
* Used `DefaultListModel` to dynamically manage tasks
* Implemented a custom checkbox renderer using `ListCellRenderer`
* Added mouse event handling to toggle task completion
* Designed UI using `BorderLayout`

---

## ⚠️ Problems I Faced

### 1. Checkbox inside JList

Swing does not directly support checkboxes in a `JList`.

### 2. Updating UI dynamically

Changes were not reflected instantly after user interaction.

### 3. Strike-through text

Java Swing does not provide direct support for strike-through styling.

### 4. Handling multiple events

Managing button clicks and mouse events together was challenging.

---

## ✅ How I Solved Them

### ✔ Custom Renderer

Used `ListCellRenderer` with `JCheckBox` to simulate checkbox behavior.

### ✔ UI Refresh

Used:

```
taskList.repaint();
```

to update UI instantly.

### ✔ Strike-through Effect

Used:

```
TextAttribute.STRIKETHROUGH
```

to style completed tasks.

### ✔ Event Handling

Used `ActionListener` and `MouseListener` for smooth interaction.

---

## 🚀 Future Improvements

* Add edit task feature
* Save tasks (file or database)
* Add due dates and reminders
* Dark/Light theme toggle
* Drag and drop task sorting

---

## 💡 What I Learned

* Java Swing UI design
* Custom rendering in lists
* Event-driven programming
* Handling real-world UI problems

---

## ▶️ How to Run

```
javac To_Do_List.java
java To_Do_List
```

---

## 👨‍💻 Author

Krishna

---

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!
