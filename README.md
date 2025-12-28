# AuCLick - Autocliker in Java

⚠️ **Attention: the code is educational/experimental!**
- The code is far from ideal, but the program WORKS.
- You can learn how NOT to do it, but still get a working program.

⚙ The code requires improvements, most likely the most unpleasant thing that you will notice is that you need to remove the JLabel crutches for line breaks, you also need to remove the FlowLayout, replacing all this with a GridBagLayout, for a normal grid of elements in the window. What else can be noticed is that the huge main can be divided into methods, for better code readability, and constants can be placed in a separate class.

💻 Warning for users:
The program uses a global keyboard hook (jnativehook).
On some systems, you may need to run as an administrator.

🛠 I will be glad if you fork the repository or make a pull request.

### 1. Compile:
javac -cp "lib/jnativehook-2.2.2.jar" -d bin src/AuCllick.java

### 2. To run:
java --enable-native-access=ALL-UNNAMED -cp "bin;lib/jnativehook-2.2.2.jar" AuCllick
