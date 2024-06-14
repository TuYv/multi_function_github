package com.longbig.multifunction.service.fairy.func;

import com.longbig.multifunction.service.fairy.obj.ArcanaCrest;
import com.longbig.multifunction.service.fairy.obj.Caco;
import com.longbig.multifunction.service.fairy.obj.Colorful;
import com.longbig.multifunction.service.fairy.obj.Dakila;
import com.longbig.multifunction.service.fairy.obj.Emeraldu;
import com.longbig.multifunction.service.fairy.obj.Fenrir;
import com.longbig.multifunction.service.fairy.obj.Fury;
import com.longbig.multifunction.service.fairy.obj.Gildedmane;
import com.longbig.multifunction.service.fairy.obj.Oakhoof;
import com.longbig.multifunction.service.fairy.obj.Panda;
import com.longbig.multifunction.service.fairy.obj.Player;
import com.longbig.multifunction.service.fairy.obj.Scarletgem;
import com.longbig.multifunction.service.fairy.obj.Shardik;
import com.longbig.multifunction.service.fairy.obj.Shibazuke;
import com.longbig.multifunction.service.fairy.obj.Skill;
import com.longbig.multifunction.service.fairy.obj.Steelhorn;
import com.longbig.multifunction.service.fairy.obj.Tiger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author Rick.Tu
 * @program multi_function_github
 * @description 竞技场
 * @create 2023-08-22 14:21
 **/
@Service
public class Arena {

    private int[][] skillMatrix = initSkillMatrix();

    public String vsFairy(String s) {
        StringBuilder result = new StringBuilder();
        List<String> stringList = initUNo();
        List<Player> totalList = initPlayer();
        List<Player> playerList = new ArrayList<>();
        Map<String, Player> playMap = totalList.stream().collect(Collectors.toMap(Player::getNo, Function.identity()));

        if(s.contains("xxx")) {
            for (int i = 0; i < s.length(); i++) {
                String uNo = s.substring(i, i+3);
                i+=2;
                if (!uNo.equals("xxx")) {
                    Player player = playMap.get(uNo);
                    playerList.add(player);
                    stringList.remove(player.getNo());
                    stringList.remove(player.getBro());
                }
            }
            for (String str : stringList) {
                String news = s.replace("xxx", str);
                Map<String, Player> playerMap = fairyArena(news).stream().collect(Collectors.toMap(Player::getNo, Function.identity()));
                for (Player player : playerList) {
                    Player tempPlayer = playerMap.get(player.getNo());
                    player.setRank1(player.getRank1() + tempPlayer.getRank1() * 0.0625);
                    player.setRank2(player.getRank2() + tempPlayer.getRank2() * 0.0625);
                    player.setRank3(player.getRank3() + tempPlayer.getRank3() * 0.0625);
                }
            }
            for (Player player : playerList) {
                result.append(player.printRank1()).append("\t");
            }
            Double sum = playerList.stream().map(Player::getRank1).reduce(0.0, Double::sum);
            String format = String.format("隐藏马第一轮胜率%.2f%%", (1 - sum) * 100);
            result.append(format);
            System.out.println(format);
            result.append("\r==============\r");
            System.out.println("==============");
            for (Player player : playerList) {
                result.append(player.printRank2()).append("\t");
            }
            sum = playerList.stream().map(Player::getRank2).reduce(0.0, Double::sum);
            format = String.format("隐藏马第二轮胜率%.2f%%", (1 - sum) * 100);
            result.append(format);
            System.out.println(format);
            result.append("\r==============\r");
            System.out.println("==============");
            for (Player player : playerList) {
                result.append(player.printRank3()).append("\t");
            }
            sum = playerList.stream().map(Player::getRank3).reduce(0.0, Double::sum);
            format = String.format("隐藏马第三轮胜率%.2f%%", (1 - sum) * 100);
            result.append(format);
            System.out.println(format);
        } else {
            playerList = fairyArena(s);
            for (Player player : playerList) {
                result.append(player.printRank1()).append("\t");
            }
            result.append("\r==============\r");
            System.out.println("==============");
            for (Player player : playerList) {
                result.append(player.printRank2()).append("\t");
            }
            result.append("\r==============\r");
            System.out.println("==============");
            for (Player player : playerList) {
                result.append(player.printRank3()).append("\t");
            }
        }
        return result.toString();
    }

    public List<Player> fairyArena(String s) {
        List<Player> playerList = this.initPlayer();
        List<Player> vsList = new ArrayList<>();
        Map<String, Player> playerMap = playerList.stream().collect(Collectors.toMap(Player::getNo, Function.identity()));
        for (int i = 0; i < s.length(); i++) {
            String uNo = s.substring(i, i + 3);
            i+=2;
            vsList.add(playerMap.get(uNo));
        }
        //rank1
        for (int i = 0; i < vsList.size(); i++) {
            Player player1 = vsList.get(i);
            Player player2 = vsList.get(++i);
            double sum = skillVS(player1, player2);
            player1.setRank1(sum);
            player2.setRank1(1 - sum);
        }
        //rank2
        for (int i = 0; i < vsList.size(); i++) {
            Player player1 = vsList.get(i);
            Player player2 = vsList.get(++i);
            Player player3 = vsList.get(++i);
            Player player4 = vsList.get(++i);
            double sum1 = skillVS(player1, player3);
            double sum2 = skillVS(player1, player4);
            double sum3 = skillVS(player2, player3);
            double sum4 = skillVS(player2, player4);
            player1.setRank2((sum1 * player3.getRank1() + sum2 * player4.getRank1()) * player1.getRank1());
            player2.setRank2((sum3 * player3.getRank1() + sum4 * player4.getRank1()) * player2.getRank1());
            player3.setRank2(((1 - sum1) * player1.getRank1() + (1 - sum3) * player2.getRank1()) * player3.getRank1());
            player4.setRank2(((1 - sum2) * player1.getRank1() + (1 - sum4) * player2.getRank1()) * player4.getRank1());
        }
        //ran3
        Player player1 = vsList.get(0);
        Player player2 = vsList.get(1);
        Player player3 = vsList.get(2);
        Player player4 = vsList.get(3);
        Player player5 = vsList.get(4);
        Player player6 = vsList.get(5);
        Player player7 = vsList.get(6);
        Player player8 = vsList.get(7);

        double sum15 = skillVS(player1, player5);
        double sum16 = skillVS(player1, player6);
        double sum17 = skillVS(player1, player7);
        double sum18 = skillVS(player1, player8);
        double sum25 = skillVS(player2, player5);
        double sum26 = skillVS(player2, player6);
        double sum27 = skillVS(player2, player7);
        double sum28 = skillVS(player2, player8);
        double sum35 = skillVS(player3, player5);
        double sum36 = skillVS(player3, player6);
        double sum37 = skillVS(player3, player7);
        double sum38 = skillVS(player3, player8);
        double sum45 = skillVS(player4, player5);
        double sum46 = skillVS(player4, player6);
        double sum47 = skillVS(player4, player7);
        double sum48 = skillVS(player4, player8);

        player1.setRank3((sum15 * player5.getRank2() + sum16 * player6.getRank2() + sum17 * player7.getRank2() + sum18 * player8.getRank2()) * player1.getRank2());
        player2.setRank3((sum25 * player5.getRank2() + sum26 * player6.getRank2() + sum27 * player7.getRank2() + sum28 * player8.getRank2()) * player2.getRank2());
        player3.setRank3((sum35 * player5.getRank2() + sum36 * player6.getRank2() + sum37 * player7.getRank2() + sum38 * player8.getRank2()) * player3.getRank2());
        player4.setRank3((sum45 * player5.getRank2() + sum46 * player6.getRank2() + sum47 * player7.getRank2() + sum48 * player8.getRank2()) * player4.getRank2());
        player5.setRank3(((1 - sum15) * player1.getRank2() + (1 - sum25) * player2.getRank2() + (1 - sum35) * player3.getRank2() + (1 - sum45) * player4.getRank2()) * player5.getRank2());
        player6.setRank3(((1 - sum16) * player1.getRank2() + (1 - sum26) * player2.getRank2() + (1 - sum36) * player3.getRank2() + (1 - sum46) * player4.getRank2()) * player6.getRank2());
        player7.setRank3(((1 - sum17) * player1.getRank2() + (1 - sum27) * player2.getRank2() + (1 - sum37) * player3.getRank2() + (1 - sum47) * player4.getRank2()) * player7.getRank2());
        player8.setRank3(((1 - sum18) * player1.getRank2() + (1 - sum28) * player2.getRank2() + (1 - sum38) * player3.getRank2() + (1 - sum48) * player4.getRank2()) * player8.getRank2());

        return vsList;
    }
    public double skillVS(Player one, Player two) {
        int rate, rate2;
        Skill skillA1 = one.getSkill1();
        Skill skillB1 = one.getSkill2();
        Skill skillA2 = two.getSkill1();
        Skill skillB2 = two.getSkill2();
        rate = skillMatrix[skillA1.getOrder()][skillA2.getOrder()];
        rate2 = skillMatrix[skillB1.getOrder()][skillB2.getOrder()];
        double winRate = ((double) rate / 100) * ((double) rate2 / 100);
        double winRate2 = ((double) (100 - rate) / 100) * ((double) (100 - rate2) / 100);
        double rank3 = 1 - winRate - winRate2;
        double result = (winRate + rate * rank3 / 100) * 100;
        if (StringUtils.equals(skillA1.getCnName(),skillA2.getCnName())) {
            result = rate2;
        } else if (StringUtils.equals(skillB1.getCnName(), skillB2.getCnName())) {
            result = rate;
        }
        return result / 100;
    }

    public List<Player> initPlayer() {
        List<Player> playerList = new ArrayList<>();

        playerList.add(new Gildedmane("jco",true));
        playerList.add(new Gildedmane("jzu",false));
        playerList.add(new Scarletgem("hco",true));
        playerList.add(new Scarletgem("hzo",false));
        playerList.add(new Steelhorn("tco",true));
        playerList.add(new Steelhorn("tsa",false));
        playerList.add(new Oakhoof("mco",true));
        playerList.add(new Oakhoof("mbo",false));
        playerList.add(new Emeraldu("lco",true));
        playerList.add(new Emeraldu("lzi",false));
        playerList.add(new ArcanaCrest("lzu",true));
        playerList.add(new ArcanaCrest("lzo",false));
        playerList.add(new Colorful("czu",true));
        playerList.add(new Colorful("csa",false));
        playerList.add(new Shardik("xzu",true));
        playerList.add(new Shardik("xbo",false));
        playerList.add(new Fenrir("nzu",true));
        playerList.add(new Fenrir("nzi",false));
        playerList.add(new Fury("nzo",true));
        playerList.add(new Fury("nsa",false));
        playerList.add(new Dakila("yzo",true));
        playerList.add(new Dakila("ybo",false));
        playerList.add(new Caco("czo",true));
        playerList.add(new Caco("czi",false));
        playerList.add(new Shibazuke("gsa",true));
        playerList.add(new Shibazuke("gbo",false));
        playerList.add(new Panda("xsa",true));
        playerList.add(new Panda("xzi",false));
        playerList.add(new Tiger("hbo",true));
        playerList.add(new Tiger("hzi",false));

        return playerList;
    }

    public int[][] initSkillMatrix() {
        int[][] skillMatrix = new int[6][6];
        skillMatrix[0][0] = 50;
        skillMatrix[0][1] = 75;
        skillMatrix[0][2] = 75;
        skillMatrix[0][3] = 50;
        skillMatrix[0][4] = 25;
        skillMatrix[0][5] = 25;

        skillMatrix[1][0] = 25;
        skillMatrix[1][1] = 50;
        skillMatrix[1][2] = 75;
        skillMatrix[1][3] = 75;
        skillMatrix[1][4] = 50;
        skillMatrix[1][5] = 25;

        skillMatrix[2][0] = 25;
        skillMatrix[2][1] = 25;
        skillMatrix[2][2] = 50;
        skillMatrix[2][3] = 75;
        skillMatrix[2][4] = 75;
        skillMatrix[2][5] = 50;

        skillMatrix[3][0] = 50;
        skillMatrix[3][1] = 25;
        skillMatrix[3][2] = 25;
        skillMatrix[3][3] = 50;
        skillMatrix[3][4] = 75;
        skillMatrix[3][5] = 75;

        skillMatrix[4][0] = 75;
        skillMatrix[4][1] = 50;
        skillMatrix[4][2] = 25;
        skillMatrix[4][3] = 25;
        skillMatrix[4][4] = 50;
        skillMatrix[4][5] = 75;

        skillMatrix[5][0] = 75;
        skillMatrix[5][1] = 75;
        skillMatrix[5][2] = 50;
        skillMatrix[5][3] = 25;
        skillMatrix[5][4] = 25;
        skillMatrix[5][5] = 50;

        return skillMatrix;
    }

    public List<String> initUNo() {
        List<String> s = new ArrayList<>();
        s.add("jco");
        s.add("jzu");
        s.add("hco");
        s.add("hzo");
        s.add("tco");
        s.add("tsa");
        s.add("mco");
        s.add("mbo");
        s.add("lco");
        s.add("lzi");
        s.add("lzu");
        s.add("lzo");
        s.add("czu");
        s.add("csa");
        s.add("xzu");
        s.add("xbo");
        s.add("nzu");
        s.add("nzi");
        s.add("nzo");
        s.add("nsa");
        s.add("yzo");
        s.add("ybo");
        s.add("czo");
        s.add("czi");
        s.add("gsa");
        s.add("gbo");
        s.add("xsa");
        s.add("xzi");
        s.add("hbo");
        s.add("hzi");
        return s;
    }
}
