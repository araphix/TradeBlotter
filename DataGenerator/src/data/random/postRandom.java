package data.random;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class postRandom {
	private static Connection connection = null;
	
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase?user=root&password=password");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		/
		/
		/	Run the random dataGenerator function inside a while(true) loop
		/	with some random 2-6 seconds delay
		/
		/
		/
		/
		*/
while(true){
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		                // your code here
		            	//List<String> list = new ArrayList<String>();
		        		int choice = getBetween(0,3);
		        		//int choice =1;
		        		List<String> query = new ArrayList<String>();
		        		switch(choice) {
		        			case 0:
		        				query = getStockQuery();
		        				System.out.println("IN STOCK");
		        				
		        				
							
							try {
								
								String sql = "INSERT INTO tradedata (`tradeID`, `tradeType`, `submissionDate`, `status`, `isin`, `product`, `quantity`, `price`, `quoteVolume`, `terms`, `traderID`, `firmName`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";


						        PreparedStatement ps = connection.prepareStatement(sql);
						        
//						        for(int i=1;i<12;i++)
						        
						        	ps.setString(1, query.get(0));
						        	ps.setString(2, query.get(1));
						        	ps.setString(3, query.get(2));
						        	ps.setString(4, query.get(3));
						        	ps.setString(5, "ISINX");
						        	ps.setString(6, query.get(4));
						        	ps.setString(7, query.get(5));
						        	ps.setString(8, query.get(6));
						        	ps.setString(9, query.get(7));
						        	ps.setString(10, query.get(8));
						        	ps.setString(11, query.get(9));
						        	ps.setString(12, query.get(10));
						        	
						        	
						        	
						        	
//						        	if(i==4){ ps.setString(i, "ISINX");
						        	
						        	
						        
						        ps.executeUpdate();
						        
		        			    
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		        			    
		        				
		        				
		        				System.out.println(query);
		        				break;
		        			case 1:
		        				query = getFxQuery();
		        				System.out.println("IN FX");
		        				
		        				
		        				
		        				try {
									
									String sql = "INSERT INTO tradedata VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

							        PreparedStatement ps = connection.prepareStatement(sql);
							        
							        ps.setString(1, query.get(0));
						        	ps.setString(2, query.get(1));
						        	ps.setString(3, query.get(2));
						        	ps.setString(4, query.get(3));
						        	ps.setString(5, "ISINX");
						        	ps.setString(6, query.get(4));
						        	ps.setString(7, query.get(5));
						        	ps.setString(8, query.get(6));
						        	ps.setString(9, query.get(7));
						        	ps.setString(10, query.get(8));
						        	ps.setString(11, query.get(9));
						        	ps.setString(12, query.get(10));
							        
							        ps.executeUpdate();
			        			    
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
		        				
		        				
		        				
		        				
		        				System.out.println(query);
		        				break;
		        			case 2:
		        				query = getBondQuery();
		        				
		        				
		        				try {
									
									String sql = "INSERT INTO tradedata VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

							        PreparedStatement ps = connection.prepareStatement(sql);
							        
							        ps.setString(1, query.get(0));
						        	ps.setString(2, query.get(1));
						        	ps.setString(3, query.get(2));
						        	ps.setString(4, query.get(3));
						        	ps.setString(5, "ISINX");
						        	ps.setString(6, query.get(4));
						        	ps.setString(7, query.get(5));
						        	ps.setString(8, query.get(6));
						        	ps.setString(9, query.get(7));
						        	ps.setString(10, query.get(8));
						        	ps.setString(11, query.get(9));
						        	ps.setString(12, query.get(10));
							        
							         ps.executeUpdate();
			        			    
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
		        				
		        				
		        				
		        				
		        				System.out.println("IN BOND");
		        				System.out.println(query);
		        				break;
		        			case 3:
		        				query = getTBillQuery();
		        				
		        				
		        				try {
									
									String sql = "INSERT INTO tradedata VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

							        PreparedStatement ps = connection.prepareStatement(sql);
							        
							        ps.setString(1, query.get(0));
						        	ps.setString(2, query.get(1));
						        	ps.setString(3, query.get(2));
						        	ps.setString(4, query.get(3));
						        	ps.setString(5, "ISINX");
						        	ps.setString(6, query.get(4));
						        	ps.setString(7, query.get(5));
						        	ps.setString(8, query.get(6));
						        	ps.setString(9, query.get(7));
						        	ps.setString(10, query.get(8));
						        	ps.setString(11, query.get(9));
						        	ps.setString(12, query.get(10));
							        
							         ps.executeUpdate();
			        			    
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
		        				
		        				
		        				
		        				
		        				System.out.println("IN TBILL");
		        				System.out.println(query);
		        				break;
		        		}
		        		
		            }
		        }, 
		        getBetween(3000,8000) 
		);

		

		/*
		/ Write the update query to insert the data into the database - tradeBlotter table 
		/
		/
		*/

//		System.out.println("UPDATE table VALUES ('"+ generateTradeId() +"', "+ query + ")");
	

	}}
	
	public static List<String> getStockQuery() {
		String[] stockArray = {"NASDAQ-ACRX", "NASDAQ-ACET", "NASDAQ-AKAO", "NASDAQ-ACHN", "NASDAQ-ACIW", "NASDAQ-ACRS", "NASDAQ-ADTN", "NASDAQ-ADRO", "NASDAQ-AAAP", "NASDAQ-ADES", 
				"NASDAQ-AEIS", "NASDAQ-AEGR", "NASDAQ-AEGN", "NASDAQ-AGLE", "NASDAQ-AEHR", "NASDAQ-AGEN", "NASDAQ-AGRX", "NASDAQ-AGYS", 
				"NASDAQ-AGIO", "NASDAQ-AGFS", "NASDAQ-AGFSW", "NASDAQ-AIMT", "NASDAQ-AIRM", "NASDAQ-AIRT", "NASDAQ-ATSG", "NASDAQ-ALDX", "NASDAQ-ALXN", "NASDAQ-ALCO", 
				"NASDAQ-ALGN", "NASDAQ-ALIM", "NASDAQ-AMBA", "NASDAQ-AMCX", "NASDAQ-AMKR", "NASDAQ-AMPH", 
				"NASDAQ-AMSG", "NASDAQ-AMSGP", "NASDAQ-ASYS", "NASDAQ-AFSI", "NASDAQ-AMRS", "NASDAQ-ADI", "NASDAQ-ALOG", "NASDAQ-ABAC", "NASDAQ-ARDM", "NASDAQ-ARCW", 
				"NASDAQ-ABIO", "NASDAQ-AROW", "NASDAQ-BUFF", "NASDAQ-BHBK", "NASDAQ-BLUE", "NASDAQ-BKEP", "NASDAQ-BSFT", 
				"NASDAQ-BVSN", "NASDAQ-BYFC", "NASDAQ-BWEN", "NASDAQ-BRCD", "NASDQAQ-BRKL", "NASDAQ-CHY", "NASDAQ-CHI", "NASDAQ-CCD", "NASDAQ-CTRE", "NASDAQ-CKEC", 
				"NASDAQ-CVCO", "NASDAQ-CAVM", "NASDAQ-CBFV", "NASDAQ-CBOE", "NASDAQ-CDK", "NASDAQ-CDW", "NASDAQ-CHUBK", "NASDAQ-DISCK", "NASDAQ-DISH", "NASDAQ-DVCR", 
				"NASDAQ-DLHC", "NASDAQ-EGBN", "NASDAQ-EGLE", "NASDAQ-EGRX", "NASDAQ-ELNK", "NASDAQ-EWBC", "NASDAQ-EACQ", "NASDAQ-EACQU", "NASDAQ-EACQW", "NASDAQ-EML", 
				"NASDAQ-EVBS", "NASDAQ-EVGBC", "NASDAQ-EXTR", "NASDAQ-EENX", "NASDAQ-EFBC", "NASDAQ-EFBCW", "NASDAQ-EFIN", 
				"NASDAQ-GLPG","NASDAQ-GALT","NASDAQ-GALTU","NASDAQ-GALTW","NASDAQ-GALE","NASDAQ-GLMD","NASDAQ-GLPI","NASDAQ-GPIC","NASDAQ-GRMN",
				"NASDAQ-GARS","NASDAQ-GCTS","NASDAQ-GEMP","NASDAQ-GENC","NASDAQ-GNCMA","NASDAQ-GFN","NASDAQ-GFNCP","NASDAQ-GFNSL","NASDAQ-GENE",
				"NASDAQ-GNMK","NASDAQ-GNCA","NASDAQ-GHDX","NASDAQ-GNST","NASDAQ-GNTX","NASDAQ-GLADO", "NYSE-MMM", "NYSE-WBAI", "NYSE-WUBA", "NYSE-AHC", 
				"NYSE-ATEN", "NYSE-AAC", "NYSE-AIR", "NYSE-AAN", "NYSE-ABB", "NYSE-ABT", "NYSE-ABBV", "NYSE-ANF", "NYSE-GCH", "NYSE-JEQ", "NYSE-SGF", "NYSE-ABM", 
				"NYSE-AKR", "NYSE-ACN", "NYSE-ACCO", "NYSE-ACW", "NYSE-ATV", "NYSE-ATU", "NYSE-AYI", "NYSE-ADX", "NYSE-PEO", "NYSE-AGRO", "NYSE-ADPT", "NYSE-AAP", 
				"NYSE-CLW", "NYSE-CLF", "NYSE-CLX", "NYSE-CLD", "NYSE-MYCC", "NYSE-CMS", "NYSE-CMS^B", "NYSE-CNA", "NYSE-CNHI", "NYSE-CNO", "NYSE-CEO", "NYSE-CNXC", "NYSE-COH", 
				"NYSE-COR^A", "NYSE-GLW", "NYSE-GYC", "NYSE-OFC", "NYSE-OFC^L", "NYSE-CXW", "NYSE-CZZ", "NYSE-CMRE", "NYSE-CMRE^B", "NYSE-CMRE^C", "NYSE-CMRE^D", 
				"NYSE-COTV", "NYSE-COT", "NYSE-COTY", "NYSE-CFC^B", "NYSE-CUZ", "NYSE-CVA", "NYSE-CPF", "NYSE-CPL", "NYSE-CR", "NYSE-CRD.A", "NYSE-CRD.B", "NYSE-BAP", 
				"NYSE-CYS", "NYSE-CYS^A", "NYSE-CYS^B", "NYSE-DHI", "NYSE-CB", "NYSE-DAN", "NYSE-DHR", "NYSE-DAC", "NYSE-DQ", "NYSE-DRI", "NYSE-DAR", "NYSE-DVA", "NYSE-DPM", 
				"NYSE-DCT", "NYSE-DDR", "NYSE-DDR^J", "NYSE-DDR^K", "NYSE-DF", "NYSE-DECK", "NYSE-DE", "NYSE-DEX", "NYSE-DDF", "NYSE-DKL", "NYSE-DK", "NYSE-DLPH", 
				"NYSE-DAL", "NYSE-DEL", "NYSE-DLX", "NYSE-DMD", "NYSE-DNR", "NYSE-DKT", "NYSE-DB", "NYSE-DTK", "NYSE-DXB", "NYSE-DVN", "NYSE-DV", "NYSE-DHX", "NYSE-DHT", 
				"NYSE-DEO", "NYSE-DO", "NYSE-DRII", "NYSE-DRH", "NYSE-DSX", "NYSE-DSX^B", "NYSE-DSXN", "NYSE-DKS", "NYSE-DBD", "NYSE-DLR", "NYSE-DLR^E.CL", "NYSE-DLR^F", 
				"NYSE-DLR^G", "NYSE-DLR^H", "NYSE-DLR^I", "NYSE-DGI", "NYSE-DDS", "NYSE-DDT", "NYSE-DIN", "NYSE-DPLO", "NYSE-DFS", "NYSE-DFS^B", "NYSE-DRA", "NYSE-DNI", 
				"NYSE-DTF", "NYSE-DUC", "NYSE-DUK", "NYSE-DUKH", "NYSE-DRE", "NYSE-DNB", "NYSE-DFT", "NYSE-DFT^C", "NYSE-DHG", "NYSE-DY", "NYSE-DLNG", "NYSE-DLNG^A", 
				"NYSE-ENZ", "NYSE-EOG", "NYSE-EPE", "NYSE-EPAM", "NYSE-EPR", "NYSE-EPR^C", "NYSE-EPR^E", "NYSE-EPR^F", "NYSE-EQT", "NYSE-EQGP", "NYSE-EQM", "NYSE-EFX", 
				"NYSE-LLL", "NYSE-LQ", "NYSE-LH", "NYSE-LADR", "NYSE-LDR", "NYSE-LCI", "NYSE-LPI", "NYSE-LVS", "NYSE-LHO", "NYSE-LHO^H", "NYSE-LHO^I", "NYSE-LHO^J", "NYSE-LFL", "NYSE-LDF", 
				"NYSE-LGI", "NYSE-LAZ", "NYSE-LOR", "NYSE-LZB", "NYSE-LEA", "NYSE-LEE", "NYSE-BWG", "NYSE-LM", "NYSE-LMHA", "NYSE-LMHB", "NYSE-LEG", "NYSE-CVB", "NYSE-JBK", "NYSE-KCC", "NYSE-KTH", 
				"NYSE-WLH", "NYSE-LYB", "NYSE-MTB", "NYSE-MTB.WS", "NYSE-MTB^", "NYSE-MTB^C", "NYSE-MDC", "NYSE-MHO", "NYSE-MHO^A", "NYSE-MAC", "NYSE-CLI", "NYSE-MGU", "NYSE-MIC", "NYSE-MFD", 
				"NYSE-BMA", "NYSE-M", "NYSE-MCN", "NYSE-MSP", "NYSE-MMP", "NYSE-MGA", "NYSE-MX", "NYSE-MH^A", "NYSE-MH^C", "NYSE-MHLA", "NYSE-MHNB", "NYSE-MHNC", "NYSE-MAIN", "NYSE-MSCA", "NYSE-MMD", 
				"NYSE-MNK", "NYSE-MZF", "NYSE-MANU", "NYSE-MTW", "NYSE-MFS", "NYSE-MN", "NYSE-MAN", "NYSE-MFC", "NYSE-MRO", "NYSE-MPC", "NYSE-MMI", "NYSE-MCS", "NYSE-MRIN", "NYSE-MHG", "NYSE-MPX", 
				"NYSE-HZO", "NYSE-MKL", "NYSE-VAC", "NYSE-MMC", "NYSE-MLM", "NYSE-MAS", "NYSE-DOOR", "NYSE-MTZ", "NYSE-MA", "NYSE-MTDR", "NYSE-MTRN", "NYSE-MATX", "NYSE-MLP", "NYSE-MMS", "NYSE-MXL", 
				"NYSE-NVRO", "NYSE-HYB", "NYSE-GF", "NYSE-NWHM", "NYSE-IRL", "NYSE-NEWM", "NYSE-NMFC", "NYSE-EDU", "NYSE-NEWR", "NYSE-NRZ", "NYSE-SNR", "NYSE-NWY", "NYSE-NYCB", "NYSE-NYCB^U", 
				"NSE-ABB", "NSE-APOLLOHOSP", "NSE-ASHOKLEY", "NSE-BAJFINANCE", "NSE-BAJAJFINSV", "NSE-BEL", "NSE-BHARATFORG", "NSE-BRITANNIA", "NSE-CADILAHC", "NSE-CAIRN", 
				"NSE-CASTROLIND", "NSE-COLPAL", "NSE-CONCOR", "NSE-CUMMINSIND", "NSE-DLF", "NSE-DABUR", "NSE-DIVISLAB", "NSE-EMAMILTD", "NSE-GSKCONS", "NSE-GLAXO", 
				"NSE-GLENMARK", "NSE-GODREJCP", "NSE-HINDPETRO", "NSE-HINDZINC", "NSE-IBULHSGFIN", "NSE-IOC", "NSE-JSWSTEEL", "NSE-LICHSGFIN", "NSE-MARICO", "NSE-MOTHERSUMI", 
				"NSE-NHPC", "NSE-NMDC", "NSE-OIL", "NSE-OFSS", "NSE-PIDILITIND", "NSE-PFC", "NSE-PGHH", "NSE-PNB", "NSE-RCOM", "NSE-RECLTD", "NSE-SHREECEM", "NSE-SRTRANSFIN", 
				"NSE-SIEMENS", "NSE-SAIL", "NSE-TITAN", "NSE-TORNTPHARM", "NSE-UPL", "NSE-UBL", "NSE-MCDOWELL-N", "NSE-VEDL"};

			String selectSide = getSide();
			String selectOrderDate = getOrderDate();
			
			int stockIndex = getBetween(0, stockArray.length-1);
			String selectStock = stockArray[stockIndex];
			
			String selectStatus = getStatus();
			int selectVolume = getBetween(1, 100);
			int selectQuantity = getBetween(1, selectVolume);
			
			double selectPrice;
			
			if (stockIndex < 364)
				selectPrice = (double)getBetween(100, 70000)/100;
			else
				selectPrice = (double)getBetween(7000, 2300000)/100;
			
			List<String> rowOfData = new ArrayList<String>();
			
			rowOfData.add(generateTradeId());
			rowOfData.add(selectSide);
			rowOfData.add(selectOrderDate);
			rowOfData.add(selectStatus);
			rowOfData.add(selectStock);
			rowOfData.add(Integer.toString(selectQuantity));
			rowOfData.add(Double.toString(selectPrice));
			rowOfData.add(Integer.toString(selectVolume));
			rowOfData.add(getTerms());
			rowOfData.add(getTraderId());
			rowOfData.add(getFirm());
			
			return rowOfData;
			
			
	}
	
	public static List<String> getFxQuery() {
		
		
		String[] currencyPairArray = {"AED/AUD", "AED/CAD", "AED/CHF", "AED/DKK", "AED/EUR", "AED/GBP", "AED/INR", "AED/JPY", "AED/NZD", "AED/PKR", "AED/USD", "AED/ZAR", "ALL/GBP", "ARS/AUD", "ARS/BRL", "ARS/CAD", "ARS/CHF", "ARS/EUR", "ARS/GBP", "ARS/HKD", "ARS/JPY", "ARS/MXN", "ARS/SGD", "ARS/USD", "AUD/ARS", "AUD/BRL", "AUD/CAD", "AUD/CHF", "AUD/CNY", "AUD/CZK", "AUD/DKK", "AUD/EUR", "AUD/FJD", "AUD/GBP", "AUD/HKD", "AUD/HUF", "AUD/IDR", "AUD/ILS", "AUD/INR", "AUD/JPY", "AUD/KRW", "AUD/MXN", "AUD/MYR", "AUD/NOK", "AUD/NZD", "AUD/PKR", "AUD/PLN", "AUD/SEK", "AUD/SGD", "AUD/THB", "AUD/TWD", "AUD/USD", "AUD/ZAR", "BDT/GBP", "BDT/JPY", "BGN/CNY", "BGN/DKK", "BHD/EUR", "BHD/PKR", "BND/GBP", "BRL/ARS", "BRL/AUD", "BRL/CAD", "BRL/CHF", "BRL/EUR", "BRL/HKD", "BRL/JPY", "BRL/MXN", "BRL/RUB", "BRL/SEK", "BRL/SGD", "BRL/USD", "BRL/ZAR", "BWP/CHF", "BWP/EUR", "BWP/GBP", "BWP/USD", "BWP/ZAR", "CAD/AED", "CAD/ARS", "CAD/AUD", "CAD/BRL", "CAD/CHF", "CAD/CNY", "CAD/DKK", "CAD/EUR", "CAD/GBP", "CAD/HKD", "CAD/IDR", "CAD/ILS", "CAD/INR", "CAD/JPY", "CAD/KRW", "CAD/KWD", "CAD/MXN", "CAD/MYR", "CAD/NOK", "CAD/NZD", "CAD/PKR", "CAD/SEK", "CAD/SGD", "CAD/THB", "CAD/TWD", "CAD/USD", "CAD/ZAR", "CHF/AED", "CHF/ARS", "CHF/AUD", "CHF/BGN", "CHF/BRL", "CHF/BWP", "CHF/CAD", "CHF/CNY", "CHF/CZK", "CHF/DKK", "CHF/EUR", "CHF/GBP", "CHF/HKD", "CHF/HUF", "CHF/IDR", "CHF/ILS", "CHF/INR", "CHF/ISK", "CHF/JPY", "CHF/KRW", "CHF/LVL", "CHF/MXN", "CHF/MYR", "CHF/NOK", "CHF/NZD", "CHF/PLN", "CHF/SEK", "CHF/SGD", "CHF/SZL", "CHF/THB", "CHF/TRY", "CHF/TWD", "CHF/USD", "CHF/ZAR", "CLP/GBP", "CNY/AUD", "CNY/BGN", "CNY/CAD", "CNY/CHF", "CNY/DKK", "CNY/EUR", "CNY/GBP", "CNY/HKD", "CNY/JPY", "CNY/NZD", "CNY/USD", "CNY/ZAR", "COP/DKK", "CRC/GBP", "CYP/ZAR", "CZK/DKK", "CZK/EUR", "CZK/JPY", "CZK/MXN", "CZK/NOK", "CZK/SEK", "DJF/GBP", "DKK/AED", "DKK/BGN", "DKK/BRL", "DKK/CHF", "DKK/CNY", "DKK/COP", "DKK/CZK", "DKK/EEK", "DKK/EUR", "DKK/GBP", "DKK/HKD", "DKK/HUF", "DKK/INR", "DKK/ISK", "DKK/JPY", "DKK/LVL", "DKK/MXN", "DKK/MYR", "DKK/NOK", "DKK/NZD", "DKK/PHP", "DKK/PLN", "DKK/SEK", "DKK/SGD", "DKK/TRY", "DKK/TWD", "DKK/UAH", "DKK/USD", "DKK/ZAR", "DOP/GBP", "EEK/DKK", "EEK/LVL", "EGP/JPY", "EGP/PKR", "ETB/GBP", "EUR/AED", "EUR/AFN", "EUR/ALL", "EUR/ARS", "EUR/AUD", "EUR/BAM", "EUR/BBD", "EUR/BDT", "EUR/BGN", "EUR/BHD", "EUR/BIF", "EUR/BND", "EUR/BOB", "EUR/BRL", "EUR/BSD", "EUR/BWP", "EUR/BYR", "EUR/BZD", "EUR/CAD", "EUR/CHF", "EUR/CLP", "EUR/CNY", "EUR/COP", "EUR/CRC", "EUR/CUP", "EUR/CVE", "EUR/CZK", "EUR/DJF", "EUR/DKK", "EUR/DOP", "EUR/DZD", "EUR/EEK", "EUR/EGP", "EUR/ETB", "EUR/FJD", "EUR/GBP", "EUR/GHS", "EUR/GMD", "EUR/GNF", "EUR/GTQ", "EUR/HKD", "EUR/HNL", "EUR/HRK", "EUR/HTG", "EUR/HUF", "EUR/IDR", "EUR/ILS", "EUR/INR", "EUR/IQD", "EUR/IRR", "EUR/ISK", "EUR/JMD", "EUR/JOD", "EUR/JPY", "EUR/KES", "EUR/KHR", "EUR/KRW", "EUR/KWD", "EUR/KYD", "EUR/KZT", "EUR/LAK", "EUR/LBP", "EUR/LKR", "EUR/LSL", "EUR/LTL", "EUR/LVL", "EUR/LYD", "EUR/MAD", "EUR/MDL", "EUR/MKD", "EUR/MMK", "EUR/MOP", "EUR/MRO", "EUR/MUR", "EUR/MVR", "EUR/MWK", "EUR/MXN", "EUR/MYR", "EUR/NAD", "EUR/NGN", "EUR/NIO", "EUR/NOK", "EUR/NPR", "EUR/NZD", "EUR/OMR", "EUR/PAB", "EUR/PEN", "EUR/PGK", "EUR/PHP", "EUR/PKR", "EUR/PLN", "EUR/PYG", "EUR/QAR", "EUR/RON", "EUR/RSD", "EUR/RUB", "EUR/RWF", "EUR/SAR", "EUR/SCR", "EUR/SDD", "EUR/SEK", "EUR/SGD", "EUR/SKK", "EUR/SOS", "EUR/STD", "EUR/SVC", "EUR/SYP", "EUR/SZL", "EUR/THB", "EUR/TND", "EUR/TRY", "EUR/TTD", "EUR/TWD", "EUR/TZS", "EUR/UAH", "EUR/UGX", "EUR/USD", "EUR/UYU", "EUR/UZS", "EUR/VEF", "EUR/VND", "EUR/XAF", "EUR/XOF", "EUR/XPF", "EUR/ZAR", "EUR/ZMK", "FJD/GBP", "GBP/AED", "GBP/ALL", "GBP/ARS", "GBP/AUD", "GBP/BDT", "GBP/BGN", "GBP/BHD", "GBP/BIF", "GBP/BND", "GBP/BRL", "GBP/BWP", "GBP/CAD", "GBP/CHF", "GBP/CLP", "GBP/CNY", "GBP/COP", "GBP/CRC", "GBP/CZK", "GBP/DJF", "GBP/DKK", "GBP/DOP", "GBP/DZD", "GBP/EEK", "GBP/EGP", "GBP/ETB", "GBP/EUR", "GBP/FJD", "GBP/GMD", "GBP/GTQ", "GBP/HKD", "GBP/HNL", "GBP/HRK", "GBP/HTG", "GBP/HUF", "GBP/IDR", "GBP/ILS", "GBP/INR", "GBP/IQD", "GBP/IRR", "GBP/ISK", "GBP/JMD", "GBP/JOD", "GBP/JPY", "GBP/KES", "GBP/KRW", "GBP/KWD", "GBP/KZT", "GBP/LBP", "GBP/LKR", "GBP/LTL", "GBP/LVL", "GBP/MAD", "GBP/MUR", "GBP/MWK", "GBP/MXN", "GBP/MYR", "GBP/NGN", "GBP/NIO", "GBP/NZD", "GBP/OMR", "GBP/PEN", "GBP/PGK", "GBP/PHP", "GBP/PKR", "GBP/PLN", "GBP/QAR", "GBP/RON", "GBP/RUB", "GBP/SAR", "GBP/SCR", "GBP/SEK", "GBP/SGD", "GBP/SKK", "GBP/SZL", "GBP/THB", "GBP/TND", "GBP/TRY", "GBP/TTD", "GBP/TWD", "GBP/TZS", "GBP/UAH", "GBP/UGX", "GBP/USD", "GBP/VND", "GBP/XAF", "GBP/XPF", "GBP/ZAR", "GBP/ZMK", "GHS/EUR", "GHS/USD", "GMD/GBP", "GTQ/GBP", "HKD/ARS", "HKD/AUD", "HKD/BRL", "HKD/CAD", "HKD/CHF", "HKD/CNY", "HKD/DKK", "HKD/EUR", "HKD/GBP", "HKD/IDR", "HKD/INR", "HKD/JPY", "HKD/KRW", "HKD/MXN", "HKD/MYR", "HKD/NZD", "HKD/PKR", "HKD/PLN", "HKD/SEK", "HKD/SGD", "HKD/THB", "HKD/TWD", "HKD/USD", "HKD/ZAR", "HNL/GBP", "HTG/GBP", "HUF/CHF", "HUF/DKK", "HUF/EUR", "HUF/PLN", "IDR/CAD", "IDR/CHF", "IDR/CNY", "IDR/EUR", "IDR/GBP", "IDR/INR", "IDR/JPY", "IDR/KRW", "IDR/MYR", "IDR/NZD", "IDR/SGD", "IDR/THB", "IDR/TWD", "IDR/USD", "IDR/ZAR", "ILS/AUD", "ILS/CAD", "ILS/CHF", "ILS/JOD", "ILS/JPY", "ILS/SEK", "INR/AUD", "INR/CAD", "INR/CHF", "INR/CNY", "INR/EUR", "INR/GBP", "INR/HKD", "INR/JPY", "INR/KRW", "INR/MYR", "INR/NZD", "INR/PKR", "INR/SEK", "INR/THB", "INR/TWD", "INR/USD", "INR/ZAR", "IQD/GBP", "IRR/JPY", "ISK/CHF", "ISK/DKK", "ISK/GBP", "ISK/SEK", "JMD/GBP", "JOD/ILS", "JPY/AED", "JPY/ARS", "JPY/AUD", "JPY/BRL", "JPY/CAD", "JPY/CHF", "JPY/CNY", "JPY/CZK", "JPY/DKK", "JPY/EUR", "JPY/GBP", "JPY/HKD", "JPY/IDR", "JPY/ILS", "JPY/INR", "JPY/KRW", "JPY/LVL", "JPY/MXN", "JPY/MYR", "JPY/NOK", "JPY/NZD", "JPY/PKR", "JPY/PLN", "JPY/RUB", "JPY/SEK", "JPY/THB", "JPY/TWD", "JPY/USD", "JPY/ZAR", "KRW/AUD", "KRW/CAD", "KRW/CHF", "KRW/CNY", "KRW/EUR", "KRW/GBP", "KRW/HKD", "KRW/IDR", "KRW/INR", "KRW/JPY", "KRW/MYR", "KRW/NZD", "KRW/SEK", "KRW/SGD", "KRW/THB", "KRW/TWD", "KRW/USD", "KRW/ZAR", "KWD/GBP", "KWD/PKR", "KZT/GBP", "LTL/LVL", "MAD/GBP", "MUR/GBP", "MWK/GBP", "MXN/ARS", "MXN/AUD", "MXN/BRL", "MXN/CAD", "MXN/CHF", "MXN/CZK", "MXN/DKK", "MXN/EUR", "MXN/GBP", "MXN/HKD", "MXN/JPY", "MXN/SGD", "MXN/USD", "MXN/ZAR", "MYR/AUD", "MYR/CAD", "MYR/CHF", "MYR/CNY", "MYR/DKK", "MYR/EUR", "MYR/GBP", "MYR/HKD", "MYR/IDR", "MYR/INR", "MYR/JPY", "MYR/KRW", "MYR/NZD", "MYR/PKR", "MYR/SGD", "MYR/THB", "MYR/TWD", "MYR/USD", "MYR/ZAR", "NGN/GBP", "NGN/JPY", "NIO/GBP", "NOK/CHF", "NOK/DKK", "NOK/EUR", "NOK/GBP", "NOK/INR", "NOK/JPY", "NOK/LVL", "NOK/SEK", "NOK/USD", "NOK/ZAR", "NZD/AED", "NZD/AUD", "NZD/CAD", "NZD/CHF", "NZD/CNY", "NZD/CZK", "NZD/DKK", "NZD/EUR", "NZD/GBP", "NZD/HKD", "NZD/HUF", "NZD/IDR", "NZD/INR", "NZD/JPY", "NZD/KRW", "NZD/MYR", "NZD/PKR", "NZD/PLN", "NZD/SEK", "NZD/SGD", "NZD/THB", "NZD/TWD", "NZD/USD", "NZD/ZAR", "OMR/GBP", "OMR/PKR", "PEN/GBP", "PGK/GBP", "PHP/DKK", "PHP/GBP", "PHP/JPY", "PHP/USD", "PKR/GBP", "PKR/JPY", "PKR/ZAR", "PLN/DKK", "PLN/EUR", "PLN/HUF", "PLN/JPY", "PLN/NOK", "PLN/SEK", "QAR/GBP", "QAR/PKR", "QAR/ZAR", "RON/GBP", "RUB/GBP", "RUB/JPY", "RUB/LVL", "RUB/USD", "SAR/PKR", "SCR/GBP", "SEK/AUD", "SEK/CAD", "SEK/CHF", "SEK/CZK", "SEK/DKK", "SEK/EUR", "SEK/GBP", "SEK/ILS", "SEK/INR", "SEK/ISK", "SEK/JPY", "SEK/LVL", "SEK/NOK", "SEK/ZAR", "SGD/ARS", "SGD/AUD", "SGD/BRL", "SGD/CAD", "SGD/CHF", "SGD/CNY", "SGD/DKK", "SGD/EUR", "SGD/GBP", "SGD/HKD", "SGD/IDR", "SGD/INR", "SGD/JPY", "SGD/KRW", "SGD/MXN", "SGD/MYR", "SGD/NZD", "SGD/PKR", "SGD/PLN", "SGD/SEK", "SGD/THB", "SGD/TWD", "SGD/USD", "SGD/ZAR", "SZL/CHF", "SZL/EUR", "SZL/GBP", "SZL/USD", "THB/AUD", "THB/CAD", "THB/CHF", "THB/CNY", "THB/EUR", "THB/GBP", "THB/HKD", "THB/IDR", "THB/INR", "THB/JPY", "THB/KRW", "THB/MYR", "THB/NZD", "THB/PKR", "THB/SGD", "THB/TWD", "THB/USD", "THB/ZAR", "TND/GBP", "TRY/CHF", "TRY/DKK", "TRY/JPY", "TRY/ZAR", "TTD/GBP", "TWD/AUD", "TWD/CAD", "TWD/CHF", "TWD/CNY", "TWD/DKK", "TWD/GBP", "TWD/HKD", "TWD/IDR", "TWD/INR", "TWD/JPY", "TWD/KRW", "TWD/MYR", "TWD/NZD", "TWD/PKR", "TWD/SEK", "TWD/SGD", "TWD/THB", "TWD/USD", "TWD/ZAR", "TZS/ZAR", "UAH/DKK", "USD/AED", "USD/ALL", "USD/AMD", "USD/ARS", "USD/AUD", "USD/BDT", "USD/BGN", "USD/BHD", "USD/BIF", "USD/BMD", "USD/BND", "USD/BOB", "USD/BRL", "USD/BWP", "USD/BZD", "USD/CAD", "USD/CHF", "USD/CLP", "USD/CNY", "USD/COP", "USD/CRC", "USD/CUP", "USD/CVE", "USD/CZK", "USD/DJF", "USD/DKK", "USD/DOP", "USD/DZD", "USD/EEK", "USD/EGP", "USD/ETB", "USD/EUR", "USD/FJD", "USD/GBP", "USD/GEL", "USD/GHS", "USD/GMD", "USD/GNF", "USD/GTQ", "USD/HKD", "USD/HNL", "USD/HRK", "USD/HTG", "USD/HUF", "USD/IDR", "USD/ILS", "USD/INR", "USD/IQD", "USD/IRR", "USD/ISK", "USD/JOD", "USD/JPY", "USD/KES", "USD/KHR", "USD/KMF", "USD/KRW", "USD/KWD", "USD/KZT", "USD/LAK", "USD/LBP", "USD/LKR", "USD/LSL", "USD/LTL", "USD/LVL", "USD/LYD", "USD/MAD", "USD/MDL", "USD/MKD", "USD/MMK", "USD/MOP", "USD/MRO", "USD/MUR", "USD/MVR", "USD/MWK", "USD/MXN", "USD/MYR", "USD/NAD", "USD/NGN", "USD/NIO", "USD/NOK", "USD/NPR", "USD/NZD", "USD/OMR", "USD/PAB", "USD/PEN", "USD/PGK", "USD/PHP", "USD/PKR", "USD/PLN", "USD/PYG", "USD/QAR", "USD/RON", "USD/RSD", "USD/RUB", "USD/RWF", "USD/SAR", "USD/SCR", "USD/SDD", "USD/SEK", "USD/SGD", "USD/SKK", "USD/SOS", "USD/STD", "USD/SVC", "USD/SYP", "USD/SZL", "USD/THB", "USD/TND", "USD/TRY", "USD/TWD", "USD/TZS", "USD/UAH", "USD/UYU", "USD/UZS", "USD/VEF", "USD/VND", "USD/XAF", "USD/XOF", "USD/XPF", "USD/YER", "USD/ZAR", "USD/ZMK", "VEF/EUR", "VEF/USD", "VND/JPY", "VND/XAF", "XAG/AUD", "XAG/CAD", "XAG/CHF", "XAG/EUR", "XAG/GBP", "XAG/INR", "XAG/TRY", "XAG/USD", "XAG/ZAR", "XAU/AUD", "XAU/CAD", "XAU/CHF", "XAU/EUR", "XAU/GBP", "XAU/INR", "XAU/TRY", "XAU/USD", "XAU/ZAR", "XPD/EUR", "XPD/USD", "XPF/GBP", "XPT/EUR", "XPT/USD", "ZAR/AED", "ZAR/AUD", "ZAR/BWP", "ZAR/CAD", "ZAR/CHF", "ZAR/CNY", "ZAR/CYP", "ZAR/DKK", "ZAR/EUR", "ZAR/GBP", "ZAR/HKD", "ZAR/IDR", "ZAR/INR", "ZAR/KRW", "ZAR/MYR", "ZAR/NOK", "ZAR/NZD", "ZAR/PHP", "ZAR/PKR", "ZAR/SEK", "ZAR/SGD", "ZAR/THB", "ZAR/TRY", "ZAR/TWD", "ZAR/USD", "ZMK/ZAR", "IDR/AUD", "IDR/HKD", "ZAR/JPY", "GBP/NOK", "NZD/PHP"};
		String[] price = {"0.2674", "0.2715", "0.2545", "1.5262", "0.2047", "0.1759", "12.132", "22.155", "0.3514", "23.317", "0.2723", "1.802", "0.0061", "0.2424", "0.4115", "0.2475", "0.2311", "0.1853", "0.1589", "1.928", "20.127", "3.0741", "0.3185", "0.248", "4.0038", "1.6788", "1.0206", "0.9555", "6.588", "19.057", "5.6978", "0.764", "1.8411", "0.6553", "7.9515", "211.62", "9185.7", "3.6252", "45.569", "83.012", "1124.03", "12.5943", "3.093", "5.95", "1.3095", "87.721", "3.0188", "6.8548", "1.3121", "30.122", "28.867", "1.0227", "6.766", "0.009", "1.1355", "4.4087", "3.7966", "1.9897", "227.15", "0.4952", "2.3588", "0.5919", "0.5997", "0.5615", "0.4522", "4.663", "49.15", "7.4228", "18.329", "4.0553", "0.772", "0.6017", "4.0163", "0.1427", "0.1146", "0.0983", "0.1521", "1.0243", "3.678", "3.9208", "0.9791", "1.6568", "0.9355", "6.4515", "5.5847", "0.7481", "0.6415", "7.7875", "8995.4", "3.5507", "44.806", "81.24", "1100.73", "0.2818", "12.335", "3.029", "5.8292", "1.2841", "86.16", "6.7265", "1.285", "29.494", "28.435", "1.0012", "6.6277", "3.9297", "4.2", "1.0453", "1.5658", "1.7696", "6.7705", "1.071", "6.9113", "19.977", "5.9668", "0.7996", "0.6872", "8.3182", "222.317", "9636.8", "3.7921", "47.703", "122.7", "86.77", "1179.3", "0.5672", "13.174", "3.2444", "6.2204", "1.3709", "3.1644", "7.1729", "1.3765", "6.9408", "31.597", "1.6502", "30.337", "1.0703", "7.0894", "0.0014", "0.1494", "0.2228", "0.1514", "0.1417", "0.8491", "0.1139", "0.0982", "1.1797", "12.399", "0.1968", "0.1513", "1.0026", "0.0028", "0.0013", "15.122", "0.2974", "0.0399", "4.3388", "0.6621", "0.311", "0.3585", "0.0036", "0.6533", "0.2613", "0.3614", "16.723", "1.1566", "350.2", "3.344", "2.0964", "0.1342", "0.1149", "1.3959", "37.157", "8.0138", "20.575", "14.5551", "0.0951", "2.211", "0.5429", "1.0443", "0.2299", "7.7601", "0.5296", "1.2025", "0.2299", "0.2769", "5.0979", "1.4119", "0.1795", "1.1871", "0.0172", "0.4759", "0.0453", "13.965", "14.787", "0.0385", "4.867", "56.6", "136.33", "5.2685", "1.3083", "1.9458", "2.6267", "92.654", "1.9483", "0.4964", "1607.36", "1.6912", "9.1818", "2.2013", "1.3314", "8.4801", "3966", "2.5932", "1.3357", "1.2508", "612.28", "8.7306", "2610", "665.68", "1.308", "108.26", "25.0225", "230.78", "7.4528", "49.221", "97.893", "15.6264", "7.649", "22.0007", "2.4384", "0.8571", "1.9638", "37.021", "9345.4", "10.527", "10.4047", "24.788", "7.3737", "52.2", "277.174", "12020", "4.7367", "59.7557", "1535.2", "13608.614", "153.37", "112.268", "0.9273", "108.617", "106.64", "5306.9", "1497.1", "0.3723", "1.0841", "194.23", "10531.1", "2007", "146.84", "8.6549", "3.4517", "0.7075", "1.6416", "11.019", "15.955", "61.749", "8.442", "10.5289", "371.75", "39.55", "16.848", "198.76", "16.292", "4.0853", "8.6549", "200.6", "28.78", "7.7835", "93.938", "1.715", "0.5085", "1.313", "3.6761", "3.2793", "57.852", "114.85", "3.9542", "6086.6", "4.8196", "4.2713", "105.464", "40.538", "777.3", "5.016", "16.227", "312.37", "8.9702", "1.7185", "30.575", "2101.4", "24391.8", "11.47", "61.302", "8.6933", "39.706", "1.9108", "2.0642", "8.3485", "37.997", "1984.22", "10.5233", "3045.9", "1.3384", "26.033", "2159.89", "5.752", "25695", "642.957", "642.957", "116.86", "8.8472", "6331.8", "0.3539", "5.725", "158.5", "6.2005", "1.5247", "107.45", "2.2807", "0.5768", "1871.8", "1.9638", "2.595", "9.832", "1.5568", "1.4584", "730.5", "10.049", "3041.7", "792.46", "29.039", "267.59", "8.697", "58.3", "113.51", "18.212", "8.88", "25.51", "1.1643", "2.8003", "43.1125", "12.508", "12.119", "29.485", "8.5534", "62.027", "323", "14011", "5.5313", "69.449", "1780.6", "15784", "178.21", "130.21", "1.0753", "126.6", "123.6", "1714.4", "0.4319", "225.21", "2342.6", "170.71", "4.0218", "0.8253", "12.782", "45.86", "230.4", "19.218", "4.7169", "237.42", "34.142", "1.9999", "0.5898", "4.3803", "3.803", "67.108", "133.9", "4.609", "5.6749", "4.9547", "47.024", "5.8551", "18.815", "10.4795", "2.001", "35.639", "10.08", "46", "2.2155", "2.4074", "9.683", "45.64", "2057", "12.202", "3151", "1.561", "29798", "748.84", "139.26", "10.3106", "7373", "0.5005", "0.6648", "0.0226", "0.08", "0.5033", "0.1257", "0.2131", "0.1283", "0.1201", "0.8282", "0.7159", "0.0961", "0.0824", "1155", "5.7398", "10.438", "141.33", "1.5837", "0.3889", "0.1649", "11.012", "0.3793", "0.8619", "0.165", "3.7869", "3.6516", "0.1286", "0.8504", "0.0339", "0.0161", "0.0045", "0.0266", "0.0036", "0.0142", "1.1106", "0.0104", "0.0717", "0.0083", "0.0071", "0.005", "0.9032", "12.551", "0.0337", "0.0143", "0.0001", "0.3277", "0.3159", "0.0111", "0.0735", "0.2751", "0.2809", "0.263", "0.2007", "22.84", "1.8882", "0.022", "0.0225", "0.021", "0.1449", "0.0141", "0.0144", "0.1748", "1.825", "24.717", "0.068", "0.0288", "1.9204", "0.1507", "0.6623", "0.6353", "0.0224", "0.1487", "0.0005", "0.0077", "0.0049", "0.0289", "0.0033", "0.0345", "0.0075", "4.9666", "0.0452", "0.0482", "0.012", "0.0205", "0.0123", "1.1507", "0.0794", "0.2299", "0.0685", "0.0092", "0.0079", "0.0958", "110.64", "0.0437", "0.5492", "13.5373", "0.6529", "0.1517", "0.0373", "0.0717", "0.0158", "1.0556", "0.0363", "0.3762", "8.2583", "0.3628", "0.349", "0.0123", "0.0816", "0.0872", "0.089", "0.0832", "0.5744", "0.0655", "0.0571", "0.6932", "8.0086", "3.9642", "7.237", "0.2697", "0.1143", "0.006", "0.0011", "2.626", "2.5317", "0.0875", "0.5892", "2.2999", "303.96", "0.0043", "0.2053", "0.0763", "0.0208", "0.0042", "0.3158", "0.0791", "0.1339", "0.0807", "0.0756", "1.5057", "0.4501", "0.0604", "0.0518", "0.6284", "6.566", "0.1037", "0.0809", "0.5364", "0.317", "0.3237", "0.303", "2.0891", "1.8197", "0.2441", "0.2077", "2.5213", "2912.7", "14.517", "26.323", "366.33", "0.4158", "27.832", "0.416", "9.5503", "9.2075", "0.3183", "2.1449", "0.0042", "0.5334", "0.0293", "16.01", "0.955", "0.1283", "0.11", "7.6481", "13.903", "0.091", "1.1496", "0.1719", "1.1375", "2.8213", "0.7631", "0.778", "0.7278", "5.0283", "14.483", "4.3453", "0.5818", "0.4999", "6.069", "161.21", "7011.2", "34.719", "63.344", "857.96", "2.3605", "66.81", "2.2978", "5.2315", "1.0015", "22.988", "22.054", "0.7798", "5.16", "1.6805", "222.39", "0.2282", "0.252", "0.1277", "0.0147", "1.8562", "0.0229", "0.0075", "0.9491", "0.077", "1.8721", "0.2512", "69.979", "27.288", "1.9639", "2.2641", "0.1773", "23.52", "1.8163", "0.2003", "0.0212", "2.6612", "0.017", "0.0325", "22.837", "0.0521", "0.1457", "0.1487", "13.87", "2.7859", "0.8279", "0.1114", "0.0953", "0.5282", "6.6518", "17.105", "12.0847", "0.0789", "0.8675", "0.9873", "3.0474", "0.7609", "1.2871", "0.7769", "0.7272", "5.0142", "4.3313", "0.5811", "0.4992", "6.0531", "6991.3", "34.788", "63.138", "855.51", "9.5949", "2.3538", "0.9989", "66.807", "2.2958", "5.2204", "23.215", "22.652", "0.7792", "5.1592", "0.1385", "0.1112", "0.0955", "0.1475", "0.0325", "0.0332", "0.0311", "0.2144", "0.0244", "0.0213", "0.2588", "298.93", "1.4851", "2.7015", "36.586", "0.1007", "0.0429", "2.8558", "0.0427", "0.945", "0.0326", "0.2201", "0.4471", "0.604", "3.599", "52.371", "4.2855", "0.1002", "0.0336", "0.0343", "0.0321", "0.227", "0.1886", "0.022", "0.2668", "308.22", "1.5432", "2.785", "38.942", "0.1038", "0.0438", "2.9308", "0.23", "0.044", "1.0108", "0.0343", "0.227", "0.0044", "0.6964", "3.6729", "102.614", "363.44", "3.9129", "0.9771", "69.209", "1.4636", "0.377", "1205", "1", "1.271", "6.8585", "1.66", "6.3362", "1.937", "0.9975", "0.9344", "467.75", "6.5916", "1926.2", "497.24", "0.977", "83.015", "18.641", "175.8", "5.5665", "37.217", "74", "11.6938", "5.6906", "16.434", "0.7467", "1.8188", "0.6405", "1.765", "1.484", "26.25", "6905.4", "7.8637", "7.7725", "18.516", "5.4965", "38.991", "207.29", "8985", "3.543", "44.6202", "1166.5", "10300", "115.096", "0.7035", "81.117", "80.5", "4034.9", "369.5", "1098.53", "0.2815", "145.08", "8015", "1498", "110.61", "6.662", "2.5774", "0.5287", "1.251", "8.325", "11.926", "46.514", "6.3061", "7.864", "281", "29.55", "12.63", "151", "12.329", "3.0229", "6.662", "151.76", "21.5", "5.815", "70.569", "1.2801", "0.383", "0.9808", "2.805", "2.4495", "45.51", "85.6", "2.9477", "4546.5", "3.6408", "3.2208", "79.444", "30.567", "586", "3.75", "12.0151", "246.62", "6.7046", "1.2827", "22.834", "1555", "18704", "8.5662", "45.794", "6.6624", "29.4678", "1.435", "1.5425", "29.165", "1482.1", "7.86", "19.446", "1613.4", "4.2904", "19460", "484.71", "484.75", "89.722", "213.23", "6.6188", "4773.8", "0.1752", "0.232", "0.0041", "0.0249", "30.16", "30.84", "28.8033", "23.09", "19.76", "1374.89", "47.73", "30.856", "204.51", "1389.6", "1418.4", "1327.03", "1062.07", "910.2", "63293", "2187.11", "1420.68", "9414.4", "592.05", "794", "0.0071", "1318.77", "1766", "0.5531", "0.1475", "0.9716", "0.1506", "0.1409", "0.9717", "0.0658", "0.8387", "0.1124", "0.0967", "1.1728", "1355", "6.7103", "165.7954", "0.46", "0.8766", "0.1935", "6.5686", "12.927", "1.0112", "0.1935", "4.4427", "0.2326", "4.2742", "0.1506", "0.0014", "0.011", "0.0009", "12.351", "8.678", "33.038"};
		
		int index1 = getBetween(0,currencyPairArray.length - 1);
		String selectProduct = currencyPairArray[index1];
		
		String p = price[index1];
		String first = p.substring(0,p.length() - 2);
		String selectPrice = first + getBetween(10,99);
		int selectVolume = getBetween(1000, 10000);
		int selectQuantity = getBetween(100, selectVolume);
		String selectSide = getSide();
		String selectStatus = getStatus();
	
        String selectOrderDate = getOrderDate();
        List<String> rowOfData = new ArrayList<String>();
		
        rowOfData.add(generateTradeId());
		rowOfData.add(selectSide);
		rowOfData.add(selectOrderDate);
		rowOfData.add(selectStatus);
		rowOfData.add(selectProduct);
		rowOfData.add(Integer.toString(selectQuantity));
		rowOfData.add(selectPrice);
		rowOfData.add(Integer.toString(selectVolume));
		rowOfData.add(getTerms());
		rowOfData.add(getTraderId());
		rowOfData.add(getFirm());
		
		return rowOfData;

	}
	
	public static List<String> getBondQuery(){

		String[] bondArray = {"ANDHRA BANK","ASPIRE HOME FINANCE CORPORATION LIMITED","BANK OF INDIA","CANARA BANK",
				"CAPITAL LOCAL AREA BANK LIMITED","CHOLAMANDALAM INVESTMENT AND FIN. CO. LTD",
				"DEWAN HOUSING FINANCE CORPORATION LIMITED","HDB FINANCIAL SERVICES LTD",
				"HIMACHAL PRADESH STATE ELECTRICITY BOARD LIMITED","HOUSING AND URBAN DEVELOPMENT CORPORATION LIMITED",
				"HOUSING DEVELOPMENT FINANCE CORPORATION LTD","IDBI BANK LIMITED PERPETUAL",
				"INDIAN RAIL FINANCE CORPORATION LIMITED","INDIAN RENEWABLE ENERGY DEVELOPMENT AGENCY LIMITED",
				"KOTAK MAHINDRA PRIME LIMITED","MAHINDRA N MAHINDRA LIMITED","MANYATA DEVELOPERS PRIVATE LIMITED",
				"NATIONAL BANK FOR AGRICULTURE","NATIONAL BANK FOR AGRICULTURE AND RURAL DEVELOPMENT",
				"NATIONAL HIGHWAY AUTHORITY OF INDIA","NATIONAL HIGHWAYS AUTHORITY OF INDIA","NATIONAL HOUSING BANK",
				"NTPC LTD","PNB HOUSING FINANCE LTD","POWER FINANCE CORPORATION LTD","RURAL ELECTRIFICATION CORPORATION LIMITED",
				"RURAL ELECTRIFICATION CORPORATION OF INDIA","RURUAL ELECTRIFICATION CORPORATION LTD","SYNDICATE BANK",
				"TAMIL NADU GENERATION AND DISTRIBUTION CORPORATION LIMITED","TATA POWER COMPANY LIMITED","TATA STEEL LIMITED"};
		String selectBond = bondArray[getBetween(0,bondArray.length-1)];
		String selectSide = getSide();
		String selectStatus = getStatus();
		int selectVolume = getBetween(1,100);
		int selectQuantity = getBetween(1,selectVolume);
		double selectPrice = (double)getBetween(9800,10600)/100;
		String selectOrderDate = getOrderDate();
		List<String> rowOfData = new ArrayList<String>();
		
		rowOfData.add(generateTradeId());
		rowOfData.add(selectSide);
		rowOfData.add(selectOrderDate);
		rowOfData.add(selectStatus);
		rowOfData.add(selectBond);
		rowOfData.add(Integer.toString(selectQuantity));
		rowOfData.add(Double.toString(selectPrice));
		rowOfData.add(Integer.toString(selectVolume));
		rowOfData.add(getTerms());
		rowOfData.add(getTraderId());
		rowOfData.add(getFirm());
		
		return rowOfData;
        
	}
	
	public static List<String> getTBillQuery() {
		String[] tBillsArray = {"UK Gilt 2 Year Yield", "UK Gilt 5 Year Yield", "UK Gilt 10 Year Yield", "UK Gilt 30 Year Yield", "Germany Bund 2 Year Yield", "Germany Bund 5 Year Yield", "Germany Bund 10 Year Yield", "Germany Bund 30 Year Yield", "JGB 2 Year Yield", "JGB 5 Year Yield", "JGB 10 Year Yield", "JGB 30 Year Yield", "Australia Bond 2 Year Yield", "Australia Bond 5 Year Yield", "Australia Bond 10 Year Yield", "Australia Bond 15 Year Yield"};
		String[] price = {"102.06", "105.50", "112.62", "153.07", "101.28", "102.61", "100.74", "157.30", "100.55", "101.33", "101.73", "98.78", "103.81", "119.15", "121.07", "131.09"};
		
		int index1 = getBetween(0,tBillsArray.length - 1);
		String selectProduct = tBillsArray[index1];
		String p = price[index1];
		String first = p.substring(0,p.length() - 2);
		String selectPrice = first + getBetween(0,99);
		int selectVolume = getBetween(1000, 10000);
		int selectQuantity = getBetween(100, selectVolume);
		String selectSide = getSide();
		String selectStatus = getStatus();
	
        String selectOrderDate = getOrderDate();
        List<String> rowOfData = new ArrayList<String>();
		
        rowOfData.add(generateTradeId());
		rowOfData.add(selectSide);
		rowOfData.add(selectOrderDate);
		rowOfData.add(selectStatus);
		rowOfData.add(selectProduct);
		rowOfData.add(Integer.toString(selectQuantity));
		rowOfData.add(selectPrice);
		rowOfData.add(Integer.toString(selectVolume));
		rowOfData.add(getTerms());
		rowOfData.add(getTraderId());
		rowOfData.add(getFirm());
		
		return rowOfData;
	}
	
	public static String generateTradeId() {

		//check in the database for the value of tradeID in the last row of the tradeInformation.
				//----> Query the database using jdbc
		
		String tradeId = null;
		try {
			
			String sqlQuery = "SELECT * FROM tradedata ORDER BY tradeID DESC LIMIT 1;";
			Statement st = connection.createStatement();
		    ResultSet rs = st.executeQuery(sqlQuery);
		    
		    //To position the cursor to the resultset starting columns.
		    
		    rs.next();
			System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5) + rs.getString(6) );
		
			tradeId = rs.getString(1);
			
			String firstPart  = "CXIAD";
			String secondPart = tradeId.replaceAll("[^0-9]", "");
			
			//parse the int from the last tradeID value
			int secondPartInt = Integer.parseInt(secondPart);
			
			//randomly add a small number to it... in the range of 1-10
			int addRandomNum = getBetween(1,10);
			secondPartInt += addRandomNum;
			
			secondPart = Integer.toString(secondPartInt);
			
			//combine the firstpart and the secondpart
			tradeId = firstPart + secondPart;
			
			return tradeId;
					
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return tradeId;
       





		
	}
	
	public static String getSide() {
		String[] sideArray = {"Sell", "Buy"};
		return sideArray[getBetween(0, sideArray.length-1)];
	}
	
	public static String getStatus() {
		String[] statusArray = {"CANCELLED", "PENDING", "APPROVED", "PARTIALLY"};
		return statusArray[getBetween(0, statusArray.length-1)];
	}
	
	/*	Dropping the ISIN column from the schema
		
	public static String getIsin() {
		return "Isin";

	}*/
	
	public static String getTerms() {

	// Find out what terms actually are

		return "N";
	}
	
	public static String getTraderId() {


		String[] traderIDs = {"EQ41252","EQ41272","EQ41392","EQ47232","EQ49952",
				"FX41252","FX41272","FX41392","FX47232","FX49952",
				"BN41252","BN41272","BN41392","BN47232","BN49952",
				"TB41252","TB41272","TB41392","TB47232","TB49952"};

		return traderIDs[getBetween(0,traderIDs.length - 1)];
	}
	
	public static String getFirm() {
		String[] firms = {"Aarti Drugs","Aarti Ind","Aarvee Denim","Aarya Global","Aashee Infotech Aasheesh Sec","Aaswa Trading","Aayush Food","AB Corp","AB Nuvo","Abacus Computer","Aban Offshore","ABans Enterpris","ABB India","Abbott India","ABC Bearings","ABC Gas","ABC India","Abco Plastic","Abee Printer","ABG Shipyard","Bervin Invest","Beryl Drugs","Beryl Securitie","Besco","Best and Crompt","Best Boards","Best Eastern","Best Mulyankan","Besta Vision","Beta Napthol","Beta Securities","Beta-Kappa","Betala Global","Betalact Labs","Betex","BF Investment","BF Utilities","BFL Enterprises","Canstar (80L)","Canstar Cap","Cantabil Retail","Cantriple MF","Cantriple Plus","Canvay Chemical","Capco Ind","Capfin India","Capital First","Capital Trade","Capital Trust","Caplin Labs","Capman Financia","Capri Global","Capricorn","Caprihans","CaprolactumChem","Capsein Bio-Lab","Captain Pipes","Captain Poly","Carbon and Che","Carbon Everflow","Carborundum CARE","National Flask","National Ind","National Oxygen","National Perox","National Plasti","National Plywoo","National Stand","National Steel","National Switch","National Tech","Natraj Proteins","Natura Hue","Natural Biocon","Natural Capsule","NaturalExpo","Natural Stone","Naturite Agro","Nava Bharat Ent","Nava Bharat Ven","Naval Techno","Navcom Ind","Naveen Textiles","Navigant Corp.","Navin Fluorine","Navkar Builders","Navkar Corp","Navketan Merch","Navneet","Navsari Cotton","Navyug Elect","Nayagara Paper","Naysaa Sec","NB Footwear","NBCC (India)","NCC","NCC Blue Water","NCC Finance","NCL Industries","NCL Marbles","NCL Research","NCL Seccolor","NCML Industries","ND Metal","NDA Securities","NDTV","Nectar Life","Nedungadi Bank","Neelamalai Agro","Neelkanth Motel","Neelkanth Rock","Neelkanth Techn","Neeraj Paper","Neha Exports Lt","Neha Intl","Neha Proteins","Neil Industries","Nelcast","NELCO","Neo Corp","Neo Infracon","Neo Intex Mills Neogem India"};
		return firms[getBetween(0,firms.length-1)];
	}
	
	public static String getOrderDate() {
		GregorianCalendar gc = new GregorianCalendar();
		
		//Get latest date from database
		//Store it in String date
		
		
		String date;
		try {
			String sqlQuery = "SELECT * FROM tradedata ORDER BY tradeID DESC LIMIT 1;";
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sqlQuery);
			
			//To position the cursor to the resultset starting columns.
			
			rs.next();
			System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3) + rs.getString(4) + rs.getString(5) + rs.getString(6) );

			date = rs.getString(3);
			
			int year = Integer.parseInt(date.substring(0, 4));
			int month = Integer.parseInt(date.substring(5, 7))-1;
			int day = Integer.parseInt(date.substring(8, 10));
			int hour = Integer.parseInt(date.substring(11, 13));
			int minute = Integer.parseInt(date.substring(14, 16));
			int second = Integer.parseInt(date.substring(17, 19));
			gc.set(year, month, day, hour, minute, second);
			
			//Roll date by 5 to 50 seconds
			gc.add(Calendar.SECOND, getBetween(5, 50));

			return ""+gc.get(Calendar.YEAR)+"-"+
	        ""+concatZero(gc.get(Calendar.MONTH)+1)+"-"+
	        ""+concatZero(gc.get(Calendar.DATE))+" "+
	        ""+concatZero(gc.get(Calendar.HOUR))+":"+
	        ""+concatZero(gc.get(Calendar.MINUTE))+":"+
	        ""+concatZero(gc.get(Calendar.SECOND));
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "NULL";
		
		
		
		
		//-----
		
		//The previously hardcoded date --- not in use
		
//		String date = "2007-09-12 01:01:01";
		
		
	}
	
	public static String concatZero(int n) {
		if (n < 10)
			return "0"+n;
		else
			return ""+n;
	}
	
	public static int getBetween(int start, int end) {
		Random randomizer = new Random();
		return randomizer.nextInt(end - start + 1) + start;
	}
}
