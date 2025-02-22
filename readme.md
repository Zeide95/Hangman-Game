## Documentation

### Project Overview
The Hangman game is a simple word-guessing game where players attempt to guess a randomly selected word by suggesting letters or guessing the entire word. The game provides a limited number of incorrect guesses before the player loses. A visual representation of the hangman is displayed to indicate progress.

### Design Choices
- The words for the game are read from an external file (`words.txt`) to allow easy modification and expansion of the word list.
- A separate class is used to draw the hangman figure when the player makes a mistake.
- The game supports both letter-by-letter guessing and full-word guessing.
- The implementation follows a structured and modular approach for better readability and maintainability.

### Algorithms and Data Structures
- **Random Selection**: A word is randomly selected from the list using Java's `Random` class.
- **String Manipulation**: The chosen word is hidden using underscores (`_`), and correct guesses reveal the corresponding letters.
- **Looping and Conditionals**: The game logic is implemented using loops to process user input and conditional statements to handle correct and incorrect guesses.
- **Exception Handling**: The program handles file-reading errors using `try-catch` blocks to ensure smooth execution.

### Improvements Over Initial Implementation
- The original hardcoded word list was replaced with a file-based input system, making the game more flexible.
- Added support for full-word guessing, allowing players to guess the entire word at once.
- Introduced a graphical representation of the hangman to improve user experience.
- Enhanced input validation to handle repeated guesses and unexpected inputs.

### File Usage
- **Input File (`words.txt`)**: Contains a list of words from which a random word is selected for the game.
- **No Output Files**: The game does not generate any output files, as all interactions occur in the console.
