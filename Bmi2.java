import javax.swing.*;
import java.awt.*;

public class Bmi2{
    public static void main(String args[]){
		//フレームの作成とアプリ題名
    	JFrame fr = new JFrame();
        fr.setTitle("BMI計算アプリ");
        fr.setSize(900, 600);
        fr.setLocationRelativeTo(null);
    	fr.setLayout(null);



    	//ウインドウの閉じるボタンを押したらアプリ終了する
    	fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
    	
		//パネル消した
    	
    	
    	//個別の身長と体重入力指示文
    	var lbl1 = new JLabel();
    	lbl1.setBounds(20,10,400,20);
    	lbl1.setOpaque(false);
        lbl1.setFont(new Font("メイリオ", Font.BOLD, 18));
    	lbl1.setText("身長と体重を入力してBMI値を出してみよう！！");
    	fr.add(lbl1);

    	//身長のラベル
    	var lbl3 = new JLabel();
    	lbl3.setBounds(20,35,100,20);
		lbl3.setOpaque(false);
        lbl3.setFont(new Font("メイリオ", Font.BOLD, 18));
    	lbl3.setText("身長(cm)：");
   		fr.add(lbl3);
		
    	
    	//身長の入力BOX
    	var txt1 = new JTextField();
    	txt1.setBounds(125,35,70,20);
    	txt1.setForeground(Color.RED);
    	txt1.setBackground(Color.YELLOW);
        txt1.setFont(new Font("メイリオ", Font.BOLD, 18));
   		txt1.setHorizontalAlignment(JTextField.CENTER);

    	txt1.setText("");
    	fr.add(txt1);

    	//体重のラベル
    	var lbl4 = new JLabel();
    	lbl4.setBounds(200,35,100,20);
		lbl4.setOpaque(false);
        lbl4.setFont(new Font("メイリオ", Font.BOLD, 18));
    	lbl4.setText("体重(kg)：");
   		fr.add(lbl4);
    	
    	
    	//体重の入力BOX
    	var txt2 = new JTextField();
    	txt2.setBounds(300,35,70,20);
    	txt2.setForeground(Color.BLUE);
    	txt2.setBackground(Color.YELLOW);
        txt2.setFont(new Font("メイリオ", Font.BOLD, 18));
   		txt2.setHorizontalAlignment(JTextField.CENTER);
    	txt2.setText("");
    	fr.add(txt2);
		
    	
    	//BMI値算出方法
    	var lbl2 = new JLabel();
    	lbl2.setBounds(20,65,400,20);
    	lbl2.setOpaque(false);
        lbl2.setFont(new Font("メイリオ", Font.PLAIN, 18));
    	lbl2.setText("計算方法：体重(kg) ÷ (身長(m) × 身長(m))");
    	fr.add(lbl2);

    	//BMI値判定表を表で表示する
    	String [] colums = {"BMI値","判定"};
    	String [] [] data = {
    		{"18.5未満","低体重(痩せ型)"},
    		{"18.5～25未満","普通体重"},
    		{"25～30未満","肥満(1度)"},
    		{"30～35未満","肥満(2度)"},
    		{"35～40未満","肥満(3度)"},
    		{"40以上","肥満(4度)"}
    	};
    	
    	// BMI表を編集不可にするにはオーバーライドが必要
    	JTable table = new JTable(data,colums){
	    @Override  // オーバーライド
    	public boolean isCellEditable(int row, int column) {
        return false; // 全セル編集不可
    		}
		};
    	
    	table.setFont(new Font("メイリオ",Font.BOLD, 14));
    	table.setRowHeight(22);
    	JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(20, 100, 400, 150);
		fr.add(scroll);
    		
		//BMI値算出結果が出るラベル
 	    var lbl5 = new JLabel();
    	lbl5.setBounds(20,310,500,30);
    	lbl5.setOpaque(false);
        lbl5.setFont(new Font("メイリオ", Font.PLAIN, 18));
    	fr.add(lbl5);
    	
    	//判定！！
    	var lbl6 = new JLabel();
    	lbl6.setBounds(20,350,400,35);
    	lbl6.setOpaque(false);
    	lbl6.setFont(new Font("メイリオ", Font.BOLD, 30));
    	
    	fr.add(lbl6);
    	
    	//BMI値判定表からの判定
    	var lbl7 = new JLabel();
    	lbl7.setBounds(20,390,800,60);
    	lbl7.setOpaque(false);
    	lbl7.setFont(new Font("メイリオ", Font.BOLD, 50));
    	fr.add(lbl7);
    	
    	
    	var lbl8 = new JLabel();
    	lbl8.setBounds(20,455,600,30);
    	lbl8.setOpaque(false);
        lbl8.setFont(new Font("メイリオ", Font.BOLD, 30));
    	fr.add(lbl8);
    	
    	
    	//現在の身長からの目標体重
    	var lbl9 = new JLabel();
    	lbl9.setBounds(20,490,600,55);
    	lbl9.setOpaque(false);
    	lbl9.setForeground(Color.GREEN); //文字色の設定
    	lbl9.setFont(new Font("メイリオ", Font.BOLD, 50));
    	fr.add(lbl9);
    	
    	
    	//BMI値算出ボタン
        JButton btn = new JButton();
    	btn.setBounds(20,270,140,30);
        btn.setFont(new Font("メイリオ", Font.BOLD, 18));
        btn.setForeground(Color.MAGENTA);
    	btn.setText("BMI値算出");
		
    	
    	btn.addActionListener(ae-> {
    		try{
			double i1 = Double.parseDouble(txt1.getText());
			double i2 = Double.parseDouble(txt2.getText());
			double i3 = 0;
    		double i4 = 0;
    		double i5 = 0;
		    double hMeter = i1 / 100.0;
    		
			
    		//BMI値計算式
			i3 = i2 / (hMeter * hMeter);
    		
			
    		//適正体重計算式
    		i4 = (hMeter * hMeter) * 18.5;
    		
    		//適正体重計算式
    		i5 = (hMeter * hMeter) * 25.0;
    		
			lbl5.setText(String.format("BMI値は %.2f です", i3));
			lbl6.setText("判定！！");
    		lbl8.setText("あなたの適正体重範囲は");
			lbl9.setText(String.format(" %.1f ～ %.1f kgです", i4,i5));
    		
    		String result;

			if (i3 < 18.5) {
   			 	result = "低体重（やせ）";
					lbl7.setForeground(Color.BLUE); //低体重（やせ）での文字色の設定
				} else if (i3 < 25.0) {
  				  	result = "普通体重";
					lbl7.setForeground(Color.GREEN); //普通体重での文字色の設定
				} else if (i3 < 30.0) {
    				result = "肥満（1度）";
					lbl7.setForeground(Color.ORANGE); //肥満（1度）での文字色の設定
				} else if (i3 < 35.0) {
    				result = "肥満（2度以上）";
					lbl7.setForeground(Color.PINK); //肥満（2度）での文字色の設定
				} else if (i3 < 40.0) {
    				result = "肥満（3度以上）";
					lbl7.setForeground(Color.RED); //肥満（3度）での文字色の設定
				} else {
					result = "肥満（4度以上）";
					lbl7.setForeground(Color.BLACK); //肥満（4度）での文字色の設定
				}
    		
			lbl7.setText(String.format("BMI判定では%sです",result)
			);
    		
			
    		
    		
    		
    		
    		
    		} catch (NumberFormatException e) {
        	lbl5.setText("数値を正しく入力してください");
    		}
    		
			});
    		
    		fr.add(btn);
    		
    		
    		lbl5.setHorizontalAlignment(JLabel.LEFT);
    		lbl5.setVerticalAlignment(JLabel.TOP);
    		
		
    	fr.setVisible(true);
    	
    }
}
