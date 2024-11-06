import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NotebookImpl implements Notebook {
    private List<Note> notes = new ArrayList<>();

    @Override
    public void addNote(Note note) {
        notes.add(note);
    }

    @Override
    public List<Note> getNotes() {
        return notes;
    }

    @Override
    public List<Note> getNotesForDay(LocalDate date) {
        return notes.stream()
                .filter(note -> note.getDateTime().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> getNotesForWeek(LocalDate date) {
        LocalDate startOfWeek = date.with(java.time.DayOfWeek.MONDAY);
        LocalDate endOfWeek = date.with(java.time.DayOfWeek.SUNDAY);
        return notes.stream()
                .filter(note -> note.getDateTime().toLocalDate().isAfter(startOfWeek.minusDays(1)) &&
                        note.getDateTime().toLocalDate().isBefore(endOfWeek.plusDays(1)))
                .collect(Collectors.toList());
    }

    @Override
    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            for (Note note : notes) {
                writer.println(note.getDateTime().format(formatter) + "," + note.getDescription());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 2);
                LocalDateTime dateTime = LocalDateTime.parse(parts[0], formatter);
                String description = parts[1];
                notes.add(new NoteImpl(dateTime, description));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
