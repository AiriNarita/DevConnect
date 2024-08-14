
import com.example.DevConnect.domain.factory.user.UserFactory
import com.example.DevConnect.domain.model.entity.user.UserEntity
import com.example.DevConnect.domain.model.entity.user.UserRole
import com.example.DevConnect.domain.model.entity.user.UserStatusEnum
import com.example.DevConnect.domain.repository.user.UserRepository
import com.example.DevConnect.infrastructure.dto.UserSignUpForm
import com.example.DevConnect.service.EncoredService
import com.example.DevConnect.service.SignUpService
import com.example.DevConnect.service.UserValidation
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.seasar.doma.jdbc.Result

@ExtendWith(MockKExtension::class)
class SignUpServiceTest {

    @InjectMockKs
    private lateinit var signUpService: SignUpService

    @MockK
    private lateinit var userRepository: UserRepository

    @MockK
    private lateinit var encoredService: EncoredService

    @MockK
    private lateinit var userFactory: UserFactory

    @MockK
    private lateinit var userValidation: UserValidation

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `入力値が正しければSuccessを返すこと`() {

        val userForm = UserSignUpForm("test", "mail@mail.com", "password")
        val encodedPassword = "encodedPassword"
        val userEntity = UserEntity(
            userId = 1 ,
            username = userForm.username,
            email = userForm.email,
            password = encodedPassword,
            version = 1,
            userStatus = UserStatusEnum.ACTIVE,
            role = UserRole.USER,
        )


        every { userRepository.findByUsername(userForm.username) } returns null
        every { userRepository.findByEmail(userForm.email) } returns null
        every { userValidation.validateUserName(userForm.username) } returns true
        every { userValidation.validateEmail(userForm.email) } returns true
        every { userValidation.validatePassword(userForm.password) } returns true
        every { encoredService.encode(userForm.password) } returns encodedPassword
        every { userRepository.createUser(any()) } returns Result<UserEntity>(1, userEntity)

        val result = signUpService.createUser(userForm)

        assertTrue(result is OperationResult.Success)
    }
}
