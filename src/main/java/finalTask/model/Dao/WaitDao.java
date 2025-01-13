package finalTask.model.Dao;

import finalTask.model.Dto.WaitDto;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class WaitDao {
    private Connection conn;
    public WaitDao(){
        // DB 연동
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/finalTask","root", "1234");
        }catch (Exception e){System.out.println(e);}
    }

    ArrayList<WaitDto> List = new ArrayList<>();

    // 명단 등록
    public boolean waitRegist(WaitDto waitDto){
        try{
            String sql = "insert into wait(phone, memberNum) values (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, waitDto.getPhone());
            ps.setInt(2, waitDto.getMemberNum());
            int count = ps.executeUpdate();
            if (count == 1){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    // 명단 출력
    public ArrayList<WaitDto> waitPrint(){
        try{
            String sql = "select* from wait";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                WaitDto waitDto = new WaitDto(
                        rs.getInt("waitNum"),rs.getString("phone"), rs.getInt("memberNum")
                );
                List.add(waitDto);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return List;
    }













}
