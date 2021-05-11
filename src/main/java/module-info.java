module MappeDel3 {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.logging;
    opens mappe.del3.post to javafx.fxml,javafx.graphics;
    opens mappe.del3.post.model to javafx.base;
    exports mappe.del3.post;
}