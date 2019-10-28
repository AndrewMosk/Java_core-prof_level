package Lesson_3.Task_4;

class RunClient {
    public static void main(String[] args) {
        ObjectToTransfer objectToTransfer = new ObjectToTransfer(777, "888");
        new Client("localhost",8189, objectToTransfer);
    }
}
