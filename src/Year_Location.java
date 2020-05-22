public class Year_Location {
    int year;
    int x;
    int y;
    int cost;
    int total_cost;
    public Year_Location() {

    }
    public Year_Location(int year, int x, int y) {
        this.year = year;
        this.x = x;
        this.y = y;
        this.cost = 0;
    }

    public Year_Location(int year, int x, int y, int cost) {
        this.year = year;
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setTotal_cost(int total_cost) {
        this.total_cost = total_cost;
    }

    public String toString() {
        return year + " " + x + " " + y + " " + cost;
    }

    @Override
    public int hashCode() {
        return year*10000 + x*100 + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Year_Location) {
            Year_Location yl = (Year_Location)obj;
            return year == yl.year && x == yl.x && y ==yl.y;
        } else {
            return false;
        }
    }
}
