// Computer.java
public class Computer {
    // Attributes
    private final String CPU;
    private final String RAM;
    private final String Storage;
    private final String GPU;
    private final String PowerSupply;

    // Private constructor
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
        this.GPU = builder.GPU;
        this.PowerSupply = builder.PowerSupply;
    }

    // Getters
    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getStorage() {
        return Storage;
    }

    public String getGPU() {
        return GPU;
    }

    public String getPowerSupply() {
        return PowerSupply;
    }

    // Static nested Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String Storage;
        private String GPU;
        private String PowerSupply;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String Storage) {
            this.Storage = Storage;
            return this;
        }

        public Builder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        public Builder setPowerSupply(String PowerSupply) {
            this.PowerSupply = PowerSupply;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + Storage +
               ", GPU=" + GPU + ", PowerSupply=" + PowerSupply + "]";
    }
}
