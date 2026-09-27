package Week8.Assignment.CampusNoticeBroadcaster;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a notice posted by admin.
 */
public class Notice {
    private final String title;
    private final List<String> targetDepartments;

    public Notice(String title, List<String> targetDepartments) {
        this.title = title;
        this.targetDepartments = new ArrayList<>(targetDepartments);
    }

    public String getTitle() { return title; }
    public List<String> getTargetDepartments() { return targetDepartments; }

    public boolean isValid() {
        return title != null && !title.trim().isEmpty()
                && targetDepartments != null && !targetDepartments.isEmpty();
    }

    @Override
    public String toString() { return "'" + title + "' targeting " + targetDepartments; }
}
