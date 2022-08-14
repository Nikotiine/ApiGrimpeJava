package fr.nikotiine.grimper.api.bo.details;

import java.util.List;

public class AllDetailList {
    private List<Level> levelList;
    private List<Direction> directionsList;
    private List<RockType> rockTypeList;
    private List<RoutProfil> routProfilList;
    private List<ApprochType> approchTypeList;
    private List<Equipment> equipmentList;

    public AllDetailList() {
    }

    public AllDetailList(List<Level> levelList, List<Direction> directionsList, List<RockType> rockTypeList, List<RoutProfil> routProfilList, List<ApprochType> approchTypeList, List<Equipment> equipmentList) {
        this();
        this.levelList = levelList;
        this.directionsList = directionsList;
        this.rockTypeList = rockTypeList;
        this.routProfilList = routProfilList;
        this.approchTypeList = approchTypeList;
        this.equipmentList = equipmentList;
    }

    public List<Level> getLevelList() {
        return levelList;
    }

    public void setLevelList(List<Level> levelList) {
        this.levelList = levelList;
    }

    public List<Direction> getDirectionsList() {
        return directionsList;
    }

    public void setDirectionsList(List<Direction> directionsList) {
        this.directionsList = directionsList;
    }

    public List<RockType> getRockTypeList() {
        return rockTypeList;
    }

    public void setRockTypeList(List<RockType> rockTypeList) {
        this.rockTypeList = rockTypeList;
    }

    public List<RoutProfil> getRoutProfilList() {
        return routProfilList;
    }

    public void setRoutProfilList(List<RoutProfil> routProfilList) {
        this.routProfilList = routProfilList;
    }

    public List<ApprochType> getApprochTypeList() {
        return approchTypeList;
    }

    public void setApprochTypeList(List<ApprochType> approchTypeList) {
        this.approchTypeList = approchTypeList;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }
}
