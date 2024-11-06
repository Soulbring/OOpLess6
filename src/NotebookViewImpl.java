import java.util.List;

public class NotebookViewImpl implements NotebookView {
    @Override
    public void displayNotes(List<Note> notes) {
        for (Note note : notes) {
            System.out.println(note);
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
