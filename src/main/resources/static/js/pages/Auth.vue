<template>
    <v-container fluid fill-height>
        <v-row align="center" justify="center">
            <v-col cols="12" sm="8" md="4">
                <v-card class="elevation-12">
                    <v-toolbar color="primary" dark flat>
                        <v-toolbar-title>Login form</v-toolbar-title>
                        <v-spacer/>
                        <v-tooltip bottom>
<!--                            <template v-slot:activator="{ on }">-->
<!--                                <v-btn :href="source" icon large target="_blank" v-on="on">-->
<!--                                    <v-icon>mdi-code-tags</v-icon>-->
<!--                                </v-btn>-->
<!--                            </template>-->
<!--                            <span>Source</span>-->
                        </v-tooltip>
                        <v-tooltip right>
<!--                            <template v-slot:activator="{ on }">-->
<!--                                <v-btn-->
<!--                                        icon-->
<!--                                        large-->
<!--                                        href="https://codepen.io/johnjleider/pen/pMvGQO"-->
<!--                                        target="_blank"-->
<!--                                        v-on="on"-->
<!--                                >-->
<!--                                    <v-icon>mdi-codepen</v-icon>-->
<!--                                </v-btn>-->
<!--                            </template>-->
<!--                            <span>Codepen</span>-->
                        </v-tooltip>
                    </v-toolbar>
                    <v-card-text>
                        <v-form>
                            <v-text-field
                                    label="Login"
                                    name="login"
                                    prepend-icon="person"
                                    type="text"
                                    v-model="user.username"
                                    v-validate="'required'"
                            />
                            <div
                                    v-if="errors.has('username')"
                                    class="alert alert-danger"
                                    role="alert"
                            >Username is required!</div>

                            <v-text-field
                                    label="Password"
                                    name="password"
                                    prepend-icon="lock"
                                    type="password"
                                    v-model="user.password"
                                    v-validate="'required'"
                            />
                            <div
                                    v-if="errors.has('password')"
                                    class="alert alert-danger"
                                    role="alert"
                            >Password is required!</div>
                        </v-form>
                    </v-card-text>
                    <v-card-actions>
                        <v-spacer/>
                        <v-btn v-on:click="handleLogin" v-on:keyup.enter="handleLogin" color="primary">Login</v-btn>
                    </v-card-actions>
                </v-card>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
    import User from '../models/user';

    export default {
        name: "Auth",
        data() {
            return {
                user: new User('', ''),
                loading: false,
                message: ''
            };
        },
        computed: {
            loggedIn() {
                return this.$store.state.auth.status.loggedIn;
            }
        },
        created() {
            if (this.loggedIn) {
                this.$router.push('/profile');
                //this.$router.push('/');
            }
        },
        methods: {
            handleLogin() {
                this.loading = true;
                this.$validator.validateAll().then(isValid => {
                    if (!isValid) {
                        this.loading = false;
                        return;
                    }

                    if (this.user.username && this.user.password) {
                        this.$store.dispatch('auth/login', this.user).then(
                            () => {
                                this.$router.push('/profile');
                                //this.$router.push('/');
                            },
                            error => {
                                this.loading = false;
                                this.message =
                                    (error.response && error.response.data) ||
                                    error.message ||
                                    error.toString();
                            }
                        );
                    }
                });
            }
        }
    }
</script>

<style scoped>

</style>