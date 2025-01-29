package DoublyLinkedLists.UndoRedoFunction;

class TextStateNode {
    String textState;
    TextStateNode prev, next;

    public TextStateNode(String textState) {
        this.textState = textState;
        this.prev = null;
        this.next = null;
    }
}
