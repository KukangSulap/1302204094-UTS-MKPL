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

	public static int calculateTax(
			int monthlySalary,
			int otherMonthlyIncome,
			int numberOfMonthWorking,
			int deductible,
			boolean isMarried,
			int numberOfChildren
	) {

		int taxMain = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking - deductible;

		if (numberOfMonthWorking > 12 || numberOfChildren > 3) {
			System.err.println("More than 12 month working per year or 3 children");
			return 0;
		}

		int taxFree = 54000000 + (isMarried ? 4500000 : 0) + (numberOfChildren * 1500000);
		int taxableIncome = Math.max(taxMain - taxFree, 0);
		return (int) Math.round(0.05 * taxableIncome);
	}
	
}
