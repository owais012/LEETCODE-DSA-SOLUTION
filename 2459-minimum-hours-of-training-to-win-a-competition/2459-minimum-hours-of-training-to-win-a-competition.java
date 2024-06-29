class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int energyReq = 0, expReq = initialExperience;
        int hours = 0;
        for(int i = 0; i < energy.length; i++)
            energyReq += energy[i];

        if(energyReq-initialEnergy >= 0)
            hours = energyReq-initialEnergy+1;

        System.out.println(hours);

        for(int i = 0; i < experience.length; i++){
            if(experience[i] >= expReq){
                hours += experience[i] - expReq + 1;
                expReq += experience[i] - expReq + 1;
            }
            System.out.println(hours);
            expReq += experience[i];
        }

        return hours;
    }
}