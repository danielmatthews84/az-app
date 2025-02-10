import {useFormik} from 'formik';
import {createOrder, schema} from "./OrderService.tsx";
import {Stack, FormControl, InputLabel, TextField, Button, Select, MenuItem} from '@mui/material/';

function App() {

    // AuthN could be configured using an OIDC provider. The app would be responsible for caching the access tokens and refresh tokens

    // Use Formik to manage form submission and state more easily
    const formik = useFormik({
        initialValues: {
            title: '',
            firstName: '',
            lastName: ''
        },
        validationSchema: schema,
        onSubmit: async (values) => {
            let order = await createOrder(values);
            alert(`Order ${order.id} has been created`);
        }
    });

    // Using Material-UI as the component library
    return (
        <>
            <h1>Order Form</h1>
            <div>
                <form onSubmit={formik.handleSubmit}>
                    <Stack spacing={2}>
                        <FormControl fullWidth>
                            <InputLabel id="title">Title</InputLabel>
                            <Select
                                labelId="title"
                                id="title"
                                value={formik.values.title}
                                label="Title"
                                onChange={(val) => formik.setFieldValue('title', val.target.value)}
                                onBlur={formik.handleBlur}
                                error={formik.touched.title && Boolean(formik.errors.title)}
                            >
                                <MenuItem value="Mr">Mr</MenuItem>
                                <MenuItem value="Mrs">Mrs</MenuItem>
                                <MenuItem value="Other">Other</MenuItem>
                            </Select>
                        </FormControl>
                        <TextField
                            fullWidth
                            id="firstName"
                            name="firstName"
                            label="First Name"
                            value={formik.values.firstName}
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            error={formik.touched.firstName && Boolean(formik.errors.firstName)}
                            helperText={formik.touched.firstName && formik.errors.firstName}
                        />
                        <TextField
                            fullWidth
                            id="lastName"
                            name="lastName"
                            label="Last Name"
                            value={formik.values.lastName}
                            onChange={formik.handleChange}
                            onBlur={formik.handleBlur}
                            error={formik.touched.lastName && Boolean(formik.errors.lastName)}
                            helperText={formik.touched.lastName && formik.errors.lastName}
                        />
                        <Button color="primary" variant="contained" fullWidth type="submit">
                            Submit
                        </Button>
                    </Stack>
                </form>
            </div>
        </>
    )
}

export default App
