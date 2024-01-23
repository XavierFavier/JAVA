public class Gomoku extends BoardGame {
    Gomoku() {
        setSizeLine(15);
        setSizeColumn(15);
        setCheckSize(5);

        initTable();
    }
}
