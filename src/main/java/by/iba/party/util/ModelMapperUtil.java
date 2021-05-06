package by.iba.party.util;

import lombok.experimental.UtilityClass;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ModelMapperUtil {
    private final ModelMapper mapper = new ModelMapper();

    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> mapper.map(element, targetClass))
                .collect(Collectors.toList());
    }

    public <S, T> T map(S source, Class<T> targetClass) {
        return mapper.map(source, targetClass);
    }
}
