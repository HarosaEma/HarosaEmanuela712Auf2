public class main {

    public static void main(String[] args) throws Exception {
        Repository repo = new Repository();
        Controller cntr = new Controller(repo);
        View view = new View(cntr);

        view.start();

    }

}
