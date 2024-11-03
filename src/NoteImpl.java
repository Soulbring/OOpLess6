import java.time.LocalDateTime;

public class NoteImpl implements Note {
    private LocalDateTime dateTime;
    private String description;

    public NoteImpl(LocalDateTime dateTime, String description) {
        this.dateTime = dateTime;
        this.description = description;
    }

    @Override
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return dateTime.toString() + ": " + description;
    }
}
