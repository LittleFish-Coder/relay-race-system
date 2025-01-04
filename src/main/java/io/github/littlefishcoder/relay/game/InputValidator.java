// InputValidator.java
package io.github.littlefishcoder.relay.game;

import io.github.littlefishcoder.relay.model.*;

public class InputValidator {
    public Runner[] validateAndCreateRunners(String input) throws InvalidInputException {
        // 檢查基本格式
        if (input.length() != 19) {
            throw new InvalidInputException("字元數應為19");
        }
        
        String[] types = input.split("-");
        if (types.length != 5) {
            throw new InvalidInputException("必須輸入5個跑者類型");
        }
        
        Runner[] runners = new Runner[5];
        for (int i = 0; i < types.length; i++) {
            runners[i] = createRunner(types[i]);
        }
        
        return runners;
    }
    
    private Runner createRunner(String type) throws InvalidInputException {
        switch (type) {
            case "str":
                return new StrengthRunner();
            case "dex":
                return new AgilityRunner();
            default:
                throw new InvalidInputException("無效的跑者類型: " + type);
        }
    }
    
    public int[] validateSkillInput(String input) throws InvalidInputException {
        try {
            String[] parts = input.split("-");
            if (parts.length != 2) {
                throw new InvalidInputException("技能輸入格式錯誤");
            }
            
            int frozen = Integer.parseInt(parts[0]);
            int field = Integer.parseInt(parts[1]);
            
            if (frozen + field != GameConstants.TOTAL_SKILLS) {
                throw new InvalidInputException("技能總數必須為" + GameConstants.TOTAL_SKILLS);
            }
            
            if (frozen < 0 || field < 0) {
                throw new InvalidInputException("技能數量不能為負數");
            }
            
            return new int[]{frozen, field};
        } catch (NumberFormatException e) {
            throw new InvalidInputException("技能數量必須為數字");
        }
    }
    
    public int[] validateSkillUseInput(String input, Player player) throws InvalidInputException {
        try {
            String[] parts = input.split("-");
            if (parts.length != 2) {
                throw new InvalidInputException("技能使用格式錯誤");
            }
            
            int frozen = Integer.parseInt(parts[0]);
            int field = Integer.parseInt(parts[1]);
            
            // 檢查使用數量是否合法
            if (frozen > 1 || field > 1) {
                throw new InvalidInputException("每回合每種技能最多使用1次");
            }
            
            // 檢查剩餘數量是否足夠
            if (frozen > player.getRemainingFrozenSkills()) {
                throw new InvalidInputException("冰凍技能剩餘數量不足");
            }
            if (field > player.getRemainingFieldSkills()) {
                throw new InvalidInputException("力場技能剩餘數量不足");
            }
            
            return new int[]{frozen, field};
        } catch (NumberFormatException e) {
            throw new InvalidInputException("技能使用數量必須為數字");
        }
    }
}