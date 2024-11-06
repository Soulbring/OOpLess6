import java.time.LocalDate;
import java.util.List;

public interface Notebook {
    void addNote(Note note);
    List<Note> getNotes();
    List<Note> getNotesForDay(LocalDate date);
    List<Note> getNotesForWeek(LocalDate date);
    void saveToFile(String filename);
    void loadFromFile(String filename);
}
