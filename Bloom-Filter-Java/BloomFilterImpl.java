import java.util.List;
import java.util.function.ToIntFunction;

public class BloomFilterImpl<T> implements BloomFilter {
    private final long[] array;
    private final int size;
    private final List<ToIntFunction<T>> hasFunctions;

    public BloomFilterImpl(long[] array, int size, List<ToIntFunction<T>> hasFunctions) {
        this.array = array;
        this.size = size;
        this.hasFunctions = hasFunctions;
    }

    public static <T> Builder<T> builder(){ return new Builder<>(); }

    public static class Builder<T> {
        private  int size;
        private List<ToIntFunction<T>> hashFunctions;
        public Builder<T> withSize(int size){
            if(Integer.bitCount(size) !=1){
                throw new IllegalArgumentException("Consider size being"+
                        "1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096.... Where Integer.bitCount(size) == 1 ");

            }
            this.size = size;
            return this;
        }

        public Builder<T> withHashFunctions(List<ToIntFunction<T>> hashFunctions) {
            this.hashFunctions = hashFunctions;
            return this;
        }
        public BloomFilterImpl<T> build(){
            return  new BloomFilterImpl<>(new long[size >>> 6], size, hashFunctions);
        }
    }

    private  int mapHash(int  hash){
        return hash & (size-1);
    }

    @Override
    public void add(Object value) {
        for(ToIntFunction<T> function : hasFunctions){
            int hash = mapHash(function.applyAsInt((T) value));
            array[hash >>> 6] |= 1L << hash;
        }
    }

    @Override
    public boolean mightContain(Object value) {
        for(ToIntFunction<T> function  : hasFunctions){
            int hash = mapHash(function.applyAsInt((T) value));
            if((array[hash >>> 6] & (1L << hash)) ==0){
                return false;
            }
        }
        return true;
    }
}
