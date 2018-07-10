package thinkinjava.exercise.chap4;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/7/4
 */
public class Chair {
    static boolean gcrun = false;
    static boolean f = false;
    static int created = 0;
    static int finalized = 0;
    int i;

    Chair() {
        i = ++created;
        if (created == 47) {
            System.out.println("created 47");
        }
    }

    @Override
    protected void finalize() {
        if (!gcrun) {
            gcrun = true;
        }
        System.out.println("Beginning  to finaliza after " +
                created + " Chairs hava been created");
        if (i == 47) {
            System.out.println("Finalizing Chair #47, " +
                    " Setting flag to stop Chair creation");
            f = true;
        }
        finalized++;
        if (finalized >= created) {
            System.out.println("All " + finalized + " finalized");
        }
    }
}
