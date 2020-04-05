package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.Objects;

    public abstract class AState{
        double cost;
        private AState parent;

        public AState(double cost, AState cameFrom) {
            this.cost = cost;
            this.parent = cameFrom;

        }

        public AState() {
            this.cost = cost;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public AState getCameFrom() {
            return parent;
        }

        public void setCameFrom(AState cameFrom) {
            this.parent = cameFrom;
        }

        public AState getParent() {
            return parent;
        }

        public void setParent(AState parent) {
            this.parent = parent;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AState aState = (AState) o;
            return Double.compare(aState.cost, cost) == 0 &&
                    Objects.equals(parent, aState.parent);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cost, parent);
        }
    }
