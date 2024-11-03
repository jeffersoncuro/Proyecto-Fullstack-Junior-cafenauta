import { Routes } from '@angular/router';
import { ListarDistritoComponent } from './componentes/distrito/listar-distrito/listar-distrito.component';
import { EditDistritoComponent } from './componentes/distrito/edit-distrito/edit-distrito.component';
import { AddDistritoComponent } from './componentes/distrito/add-distrito/add-distrito.component';
import { ListarProductoComponent } from './componentes/producto/listar-producto/listar-producto.component';
import { AddProductoComponent } from './componentes/producto/add-producto/add-producto.component';
import { EditProductoComponent } from './componentes/producto/edit-producto/edit-producto.component';
import { ListarReservaComponent } from './componentes/reserva/listar-reserva/listar-reserva.component';
import { AddReservaComponent } from './componentes/reserva/add-reserva/add-reserva.component';
import { EditReservaComponent } from './componentes/reserva/edit-reserva/edit-reserva.component';
import { ListarLocalComponent } from './componentes/local/listar-local/listar-local.component';
import { AddLocalComponent } from './componentes/local/add-local/add-local.component';
import { EditLocalComponent } from './componentes/local/edit-local/edit-local.component';
import { ListarLocalEnableComponent } from './componentes/local/listar-local-enable/listar-local-enable.component';
import { ListarReservaEnableComponent } from './componentes/reserva/listar-reserva-enable/listar-reserva-enable.component';
import { AuthGuard } from './componentes/login/helpers/auth.guard';
import { LoginComponent } from './componentes/login/login.component';

export const routes: Routes = [
    {path: 'distritos', component:ListarDistritoComponent, canActivate: [AuthGuard]},
    {path: 'nuevoDistrito', component:AddDistritoComponent, canActivate: [AuthGuard]},
    {path: 'editarDistrito/:id_dis', component:EditDistritoComponent, canActivate: [AuthGuard]},

    {path: 'productos', component:ListarProductoComponent, canActivate: [AuthGuard]},
    {path: 'nuevoProducto', component:AddProductoComponent, canActivate: [AuthGuard]},
    {path: 'editarProducto/:id_producto', component:EditProductoComponent, canActivate: [AuthGuard]},

    {path: 'reservas', component:ListarReservaComponent, canActivate: [AuthGuard]},
    {path: 'nuevaReserva', component:AddReservaComponent, canActivate: [AuthGuard]},
    {path: 'editarReserva/:idRes', component:EditReservaComponent, canActivate: [AuthGuard]},
    {path: 'reservasEnable', component:ListarReservaEnableComponent, canActivate: [AuthGuard]},

    {path: 'locales', component:ListarLocalComponent, canActivate: [AuthGuard]},
    {path: 'nuevoLocal', component:AddLocalComponent, canActivate: [AuthGuard]},
    {path: 'localesEnable', component:ListarLocalEnableComponent, canActivate: [AuthGuard]},
    {path: 'editarLocal/:id_local', component:EditLocalComponent, canActivate: [AuthGuard]},

    {path: 'login', component:LoginComponent},
    { path: '', redirectTo: '/login', pathMatch: 'full' }
];
