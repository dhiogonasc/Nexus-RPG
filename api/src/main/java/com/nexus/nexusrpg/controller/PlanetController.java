@RestController
@RequestMapping("/planet")
@RequiredArgsConstructor
public class PlanetController {

    private final PlanetService planetService;
    private final PlanetMapper planetMapper;


    @GetMapping
    public ResponseEntity<List<PlanetDTO>> listarTodos() {
        List<PlanetDTO> planets = planetService.findAll()
                .stream()
                .map(planetMapper::toDTO)
                .toList();

        return ResponseEntity.ok(planets);
    }


    @GetMapping("/{id}")
    public ResponseEntity<PlanetDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(
                planetMapper.toDTO(planetService.findById(id))
        );
    }
}
