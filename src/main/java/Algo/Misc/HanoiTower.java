package Algo.Misc;

public class HanoiTower {
    public void moveTower(int height, int fromRod, int auxRod, int toRod) {
        if (height < 1) {
            return;
        }
        moveTower(height - 1, fromRod, toRod, auxRod);
        moveDisk(fromRod, toRod);
        moveTower(height - 1, auxRod, fromRod, toRod);
    }

    public void moveDisk(int fromRod, int toRod) {
        System.out.printf("Перемещаем диск с колышка %d на колышек %d\r\n", fromRod, toRod);
    }
}
