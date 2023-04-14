package lib;

public class TaxFunction {

	/**
	 * Fungsi menghitung pajak tahunan dengan rumus 5% dari penghasilan bersih tahunan.
	 * Penghasilan bersih diperoleh dengan mengurangi penghasilan bulanan dengan pemotongan dan
	 * dikali dengan jumlah bulan dalam setahun.
	 *
	 * - belum menikah atau memiliki anak maka tidak kena pajak, jadi Rp54.000.000
	 * - sudah menikah maka ditambah sebesar Rp4.500.000
	 * - memiliki anak maka ditambah sebesar Rp4.500.000 per anak sampai anak ketiga.
	 */

	public static int calculateTax(int monthlySalary, int otherMonthlyIncome, int numberOfMonthWorking, int deductible, boolean isMarried, int numberOfChildren) {
		
		int tax = 0;
		
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
		
		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}
		
		if (isMarried) {
			tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - (54000000 + 4500000 + (numberOfChildren * 1500000))));
		}else {
			tax = (int) Math.round(0.05 * (((monthlySalary + otherMonthlyIncome) * numberOfMonthWorking) - deductible - 54000000));
		}
		
		if (tax < 0) {
			return 0;
		}else {
			return tax;
		}
			 
	}
	
}
