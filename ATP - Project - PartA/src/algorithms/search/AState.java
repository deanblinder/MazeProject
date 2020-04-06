package algorithms.search;

import algorithms.mazeGenerators.Position;

import java.util.Objects;

    public abstract class AState{
        double cost;
        private AState parent;

        public AState(double cost, AState parent) {
            this.cost = cost;
            this.parent = parent;

        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
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
            AState state = (AState) o;
            return Double.compare(state.cost, cost) == 0 &&
                    Objects.equals(parent, state.parent);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cost, parent);
        }
    }
