@RestController
@RequestMapping("/mission")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;
    private final MissionMapper missionMapper;


    @GetMapping
    public ResponseEntity<List<MissionDTO>> listarTodos() {
        List<MissionDTO> missions = missionService.findAll()
                .stream()
                .map(missionMapper::toDTO)
                .toList();

        return ResponseEntity.ok(missions);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MissionDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(
                missionMapper.toDTO(missionService.findById(id))
        );
    }
}