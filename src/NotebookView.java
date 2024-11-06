import java.util.List;

public interface NotebookView {
    void displayNotes(List<Note> notes);
    void displayMessage(String message);
}
