import { Routes } from '@angular/router';

import { HomeComponent } from '../../home/home.component';
import { UserComponent } from '../../user/user.component';
import { TablesComponent } from '../../tables/tables.component';
import { TypographyComponent } from '../../typography/typography.component';
import { IconsComponent } from '../../icons/icons.component';
import { MapsComponent } from '../../maps/maps.component';
import { NotificationsComponent } from '../../notifications/notifications.component';
import { UpgradeComponent } from '../../upgrade/upgrade.component';
import { AuthGuard } from 'app/auth.guard';
import { FirstComponent } from 'app/first/first.component';


export const AdminLayoutRoutes: Routes = [
    
    { path: 'dashboard',      component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'user',           component: UserComponent ,canActivate: [AuthGuard]},
    { path: 'table',          component: TablesComponent ,canActivate: [AuthGuard]},
    { path: 'typography',     component: TypographyComponent,canActivate: [AuthGuard] },
    { path: 'icons',          component: IconsComponent,canActivate: [AuthGuard] },
    { path: 'maps',           component: MapsComponent ,canActivate: [AuthGuard]},
    { path: 'notifications',  component: NotificationsComponent,canActivate: [AuthGuard] },
    { path: 'upgrade',        component: UpgradeComponent ,canActivate: [AuthGuard]},
];
