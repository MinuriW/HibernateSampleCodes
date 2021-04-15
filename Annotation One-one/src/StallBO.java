import java.util.List;

public class StallBO {
    StallDAO stallDAO=new StallDAO();
    public void registerStall(Stall stall) {
		stallDAO.insert(stall);
	}
	public Stall findStallById(int id) {
		return stallDAO.find(id);
	}
	public void getLicense(Stall stall) {
		stallDAO.update(stall);
	}
	public List<Stall> listStalls() {
		return stallDAO.list();
	}
}
