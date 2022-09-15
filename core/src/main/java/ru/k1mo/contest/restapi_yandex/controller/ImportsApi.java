/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package ru.k1mo.contest.restapi_yandex.controller;

import ru.k1mo.contest.restapi_yandex.model.Error;
import ru.k1mo.contest.restapi_yandex.dto.SystemItemImportRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-09T13:45:12.975114900+03:00[Europe/Moscow]")
@Validated
@Tag(name = "imports", description = "the imports API")
public interface ImportsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    void save(List<SystemItemImportRequest> systemItemImportRequest);

    /**
     * POST /imports
     * Импортирует элементы файловой системы. Элементы импортированные повторно обновляют текущие. Изменение типа элемента с папки на файл и с файла на папку не допускается. Порядок элементов в запросе является произвольным.    - id каждого элемента является уникальным среди остальных элементов   - поле id не может быть равно null   - родителем элемента может быть только папка   - принадлежность к папке определяется полем parentId   - элементы могут не иметь родителя (при обновлении parentId на null элемент остается без родителя)   - поле url при импорте папки всегда должно быть равно null   - размер поля url при импорте файла всегда должен быть меньше либо равным 255   - поле size при импорте папки всегда должно быть равно null   - поле size для файлов всегда должно быть больше 0   - при обновлении элемента обновленными считаются **все** их параметры   - при обновлении параметров элемента обязательно обновляется поле **date** в соответствии с временем обновления   - в одном запросе не может быть двух элементов с одинаковым id   - дата обрабатывается согласно ISO 8601 (такой придерживается OpenAPI). Если дата не удовлетворяет данному формату, ответом будет код 400.  Гарантируется, что во входных данных нет циклических зависимостей и поле updateDate монотонно возрастает. Гарантируется, что при проверке передаваемое время кратно секундам. 
     *
     * @param systemItemImportRequest  (optional)
     * @return Вставка или обновление прошли успешно. (status code 200)
     *         or Невалидная схема документа или входные данные не верны. (status code 400)
     */
    @Operation(
        operationId = "importsPost",
        tags = { "Базовые задачи" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Вставка или обновление прошли успешно."),
            @ApiResponse(responseCode = "400", description = "Невалидная схема документа или входные данные не верны.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/imports",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> importsPost(
        @Parameter(name = "SystemItemImportRequest", description = "") @Valid @RequestBody(required = false) List<SystemItemImportRequest> systemItemImportRequest
    ) {
        save(systemItemImportRequest);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
